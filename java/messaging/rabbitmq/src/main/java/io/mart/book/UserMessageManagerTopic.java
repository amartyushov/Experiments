package io.mart.book;

import com.google.inject.Inject;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.GetResponse;

import java.io.IOException;
import java.util.*;

/**
 * @author Aleksandr Martiushov
 */
public class UserMessageManagerTopic {

    static final String USER_TOPICS_EXCHANGE = "user-topics";

    @Inject
    RabbitMqManager rabbitMqManager;


    // this is fundamental requirement in user-to-user messaging subsystem: create exchange
    // -------------
    // sending to nonexistent exchange not only raise an exception
    // it also terminates a channel, where the error occured.
    public void onApplicationStart() {
        rabbitMqManager.call(new ChannelCallable<AMQP.Exchange.DeclareOk>() {
            public String getDescription() {
                return "Declaring topic exchange " + USER_TOPICS_EXCHANGE;
            }

            public AMQP.Exchange.DeclareOk call(Channel channel) throws IOException {
                String exchange = USER_TOPICS_EXCHANGE;

                String type = "topic";

                //survive a server restart
                boolean durable = true;

                // keep it even if nobody is using it
                boolean autoDelete = false;

                //no special arguments
                Map<String, Object> arguments = null;

                // if exchange already exist => it will do nothing (idempotent operation)
                // idempotent only if exchange props are the same, if not operation will fail
                return channel.exchangeDeclare(exchange, type, durable, autoDelete, arguments);
            }
        });
    }

    @Deprecated
    public void onUserLogin(final long userId) {
        final String queue = getUserInboxQueue(userId);

        rabbitMqManager.call(new ChannelCallable<AMQP.Queue.BindOk>() {
            public String getDescription() {
                return "Declaring user queue " + queue + ", binding it to exchange " + USER_TOPICS_EXCHANGE;
            }

            public AMQP.Queue.BindOk call(Channel channel) throws IOException {
                return declareUserMessageQueue(queue, channel);
            }
        });
    }

    private String getUserInboxQueue(long userId) {
        return "user-inbox." + userId;
    }

    @Deprecated
    private AMQP.Queue.BindOk declareUserMessageQueue(String queue, Channel channel) throws IOException {
        //survive a server restart
        boolean durable = true;

        // keep it even if nobody is using it
        boolean autoDelete = false;

        // can be consume by another connection
        boolean exclusive = false;

        //no special arguments
        Map<String, Object> arguments = null;

        // operation is idempotent, only if same params are used
        channel.queueDeclare(queue, durable, exclusive, autoDelete, arguments);

        //bind the adressee`s queue to the direct exchange
        String routingKey = queue;

        return channel.queueBind(queue, USER_TOPICS_EXCHANGE, routingKey);
        // publishing messages to the user-inboxes exchange will deliver messages to the
        // user queue whose name matches the published routing key
    }

    static final String MESSAGE_CONTENT_TYPE = "application/vnd.ccm.pmsg.v1+json";
    static final String MESSAGE_ENCODING = "UTF-8";

    @Deprecated
    public String sendUserMessage(final long userId, final String jsonMessage) {
        return rabbitMqManager.call(new ChannelCallable<String>() {
            public String getDescription() {
                return "Sending message to user " + userId;
            }

            public String call(Channel channel) throws IOException {
                String queue = getUserInboxQueue(userId);

                //it may not exist so declare it
                declareUserMessageQueue(queue, channel);

                String messageId = UUID.randomUUID().toString();

                AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                        .contentType(MESSAGE_CONTENT_TYPE)
                        .contentEncoding(MESSAGE_ENCODING)
                        .messageId(messageId)
                        .deliveryMode(2)
                        // nonPersistent 1, persistent 2 (saved on e.g. disc)
                        // Dont mess exchange and queue durability and message persistence.
                        // non persistent message stored in durable queue will be gone after
                        // a broker restart, leaving you with empty queue
                        .build();

                String routingKey = queue;

                //publish the message to direct exchange
                channel.basicPublish(USER_TOPICS_EXCHANGE, routingKey, props, jsonMessage.getBytes(MESSAGE_ENCODING));

                return messageId;
            }
        });
    }

    public List<String> fetchUserMessages(final long userId) {
        return rabbitMqManager.call(new ChannelCallable<List<String>>() {
            public String getDescription() {
                return "Fetching messages for user " + userId;
            }

            public List<String> call(Channel channel) throws IOException {
                List<String> messages = new ArrayList<String>();

                String queue = getUserInboxQueue(userId);

                // client-side ack that message was correctly received and can now be permanently destroyed
                // from the broker storage
                boolean autoAck = true;
                GetResponse getResponse;
                while ((getResponse = channel.basicGet(queue, autoAck)) != null) {
                    final String contentEncoding = getResponse.getProps().getContentEncoding();

                    messages.add(new String(getResponse.getBody(), contentEncoding));
                }
                return messages;
            }
        });
    }

    public String sendTopicMessage(final String topic, final String message) {
        return rabbitMqManager.call(new ChannelCallable<String>() {
            @Override
            public String getDescription() {
                return "Sending message to topic " + topic;
            }

            @Override
            public String call(Channel channel) throws IOException {
                String messageId = UUID.randomUUID().toString();

                AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                        .contentType(MESSAGE_CONTENT_TYPE)
                        .contentEncoding(MESSAGE_ENCODING)
                        .messageId(messageId)
                        .deliveryMode(2)
                        // nonPersistent 1, persistent 2 (saved on e.g. disc)
                        // Dont mess exchange and queue durability and message persistence.
                        // non persistent message stored in durable queue will be gone after
                        // a broker restart, leaving you with empty queue
                        .build();

                //publish the message to the topic exchange
                channel.basicPublish(USER_TOPICS_EXCHANGE, topic, props, message.getBytes(MESSAGE_ENCODING));
                return messageId;
            }
        });
    }

    public void onUserTopicInterestChange(final long userId,
                                          final Set<String> subscribes,
                                          final Set<String> unsubscribes) {
        final String queue = getUserInboxQueue(userId);

        rabbitMqManager.call(new ChannelCallable<Void>() {
            @Override
            public String getDescription() {
                return "Binding user queue " + queue + " to exchange " + USER_TOPICS_EXCHANGE + " with " +
                        subscribes + ", unbinding " + unsubscribes;
            }

            @Override
            public Void call(Channel channel) throws IOException {
                for (String subscribe : subscribes) {
                    channel.queueBind(queue, USER_TOPICS_EXCHANGE, subscribe);
                }

                for (String unsubscribe : unsubscribes) {
                    channel.queueUnbind(queue, USER_TOPICS_EXCHANGE, unsubscribe);
                }
                return null;
            }
        });
    }

    public Subscription subscribeToUserInbox(final long userId, final SubscriptionDeliverHandler handler) {
        final String queue = getUserInboxQueue(userId);
        return rabbitMqManager.createSubscription(queue, handler);
    }

}
