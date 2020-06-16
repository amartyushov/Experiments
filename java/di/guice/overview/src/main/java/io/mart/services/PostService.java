package io.mart.services;

import com.google.inject.Singleton;

/**
 * @author Aleksandr Martiushov
 */

@Singleton//JSR-330
public class PostService implements Service {

    public boolean sendMessage() {
        System.out.println("Message is sent by post (annotated)");
        return true;
    }
}
