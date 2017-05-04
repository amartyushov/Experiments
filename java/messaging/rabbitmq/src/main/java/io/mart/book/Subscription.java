package io.mart.book;

import com.google.common.base.Objects;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeoutException;

/**
 * @author Aleksandr Martiushov
 */
public class Subscription {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String queue;
    private SubscriptionDeliverHandler handler;

    private volatile DefaultConsumer consumer;

    public Subscription(String queue, DefaultConsumer consumer) {
        this.queue = queue;
        this.consumer = consumer;
    }

    public String start(Channel channel) throws IOException {
        consumer = null;

        if (channel != null) {
            try {
                consumer = new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(final String
                                                       consumerTag,
                                               final Envelope envelope,
                                               final AMQP.BasicProperties properties,
                                               final byte[] body) throws IOException {

                        handler.handleDelivery(channel, envelope, properties, body);
                    }
                };

                final boolean autoAck = false;
                final String consumerTag = channel.basicConsume(queue, autoAck, consumer);

                LOG.info("Consuming queue: " + queue + ": with tag: " + consumerTag + " on channel: "
                        + channel);

                return consumerTag;
            } catch (Exception e) {
                LOG.error("Failed to start consuming queue: " + queue, e);
                consumer = null;
            }
        }
        return null;
    }

    public void stop() {
        final Channel channel = getChannel();
        if (channel == null) {
            return;
        }

        LOG.info("Stopping subscription: " + this);
        try {
            channel.basicCancel(consumer.getConsumerTag());
        } catch (IOException e) {
            LOG.error("Failed to cancel subscription: " + this, e);
        }

        try {
            channel.close();
        } catch (TimeoutException | IOException e) {
            LOG.error("Failed to close channel: " + channel, e);
        } finally {
            consumer = null;
        }
    }

    public Channel getChannel() {
        return consumer == null ? null : consumer.getChannel();
    }

    @Override
    protected void finalize() throws Throwable {
        stop();
    }

    @Override
    public String toString() {
        final Objects.ToStringHelper tsh = Objects.toStringHelper(this).addValue(hashCode()).add("queue", queue);
        if (consumer != null) {
            tsh.add("channel", getChannel());
            tsh.add("consumerTag", consumer.getConsumerTag());
        }
        return tsh.toString();
    }
}
