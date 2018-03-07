package io.mart.services;

import com.google.inject.Singleton;

/**
 * @author Aleksandr Martiushov
 */

@Singleton
public class MockService implements Service {

    public boolean sendMessage() {
        System.out.println("mocking message");
        return true;
    }
}
