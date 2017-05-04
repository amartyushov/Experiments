package io.mart.book;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Envelope;

/**
 * @author Aleksandr Martiushov
 */
public interface SubscriptionDeliverHandler {
    void handleDelivery(Channel channel, Envelope envelope, AMQP.BasicProperties properties, byte[] body);
}
