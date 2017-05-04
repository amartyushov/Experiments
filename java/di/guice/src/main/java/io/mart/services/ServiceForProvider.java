package io.mart.services;

/**
 * @author Aleksandr Martiushov
 */
public class ServiceForProvider implements Service {
    public boolean sendMessage() {
        System.out.printf("send message by service from provider");
        return true;
    }
}
