package io.mart.book;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Aleksandr Martiushov
 */
public class RabbitMqManager implements ShutdownListener {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ConnectionFactory factory;
    private final ScheduledExecutorService executor;
    private volatile Connection connection;
    private final Set<Subscription> subscriptions;

    public RabbitMqManager(ConnectionFactory factory) {
        this.factory = factory;
        executor = Executors.newSingleThreadScheduledExecutor();
        connection = null;
        subscriptions = syncronisedSet(new HashSet<Subscription>());
    }

    private Set<Subscription> syncronisedSet(HashSet<Subscription> subscriptions) {
        return null;
        // not implemented
    }

    public void start() {
        try {
            connection = factory.newConnection();
            connection.addShutdownListener(this);
            LOG.info("Connected to " + factory.getHost() + ":" + factory.getPort());
        } catch (Exception e) {
            LOG.info("Failed to connect");
            asyncWaitAndConnect();
        }
    }

    private void asyncWaitAndConnect() {
        executor.schedule(this::start, 15, TimeUnit.SECONDS);
    }

    @Override
    public void shutdownCompleted(final ShutdownSignalException cause) {
        if (!cause.isInitiatedByApplication()) {
            LOG.error("Lost connection");
            connection = null;
            asyncWaitAndConnect();
        }
    }

    public void stop() {
        executor.shutdown();
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (final Exception e) {
            LOG.error("Failed to stop connection");
        } finally {
            connection = null;
        }
    }

    public Channel createChannel() {
        try {
            return connection == null ? null : connection.createChannel();
        } catch (final Exception e) {
            LOG.error("Failed to create channel");
            return null;
        }
    }

    public void closeChannel(final Channel channel) {
        if ((channel == null) || (!channel.isOpen())) {
            return;
        }
        try {
            channel.close();
        } catch (final Exception e) {
            LOG.error("Failed to close channel");
        }
    }

    public <T> T call(final ChannelCallable<T> callable) {
        final Channel channel = createChannel();
        if (channel != null) {
            try {
                return callable.call(channel);
            } catch (final Exception e) {
                LOG.error("failed to run " + callable.getDescription() + "on channel " + channel, e);
            } finally {
                closeChannel(channel);
            }
        }
        return null;
    }

    public Subscription createSubscription(final String queue, final SubscriptionDeliverHandler handler) {
        final Subscription subscription = null;
        //final Subscription subscription = new Subscription(queue, handler);
        subscriptions.add(subscription);
        startSubscription(subscription);
        return subscription;
    }

    private void startSubscription(Subscription subscription) {
        final Channel channel = createChannel();
        if (channel != null) {
            try {
                subscription.start(channel);
            } catch (final Exception e) {
                LOG.error("Failed to start subscription: " + subscription + " on channel: ");
            }
        }
    }

    private void restartSubscriptions() {
        LOG.info("Restarting " + subscriptions.size() + "subscriptions");
        for (final Subscription subscription : subscriptions) {
            startSubscription(subscription);
        }
    }
}
