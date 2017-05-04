package io.mart.book;

import com.rabbitmq.client.Channel;

import java.io.IOException;

/**
 * @author Aleksandr Martiushov
 */
public interface ChannelCallable<T> {
    String getDescription();

    T call(Channel channel) throws IOException;
}
