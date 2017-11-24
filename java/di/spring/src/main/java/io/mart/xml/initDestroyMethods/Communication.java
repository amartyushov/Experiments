package io.mart.xml.initDestroyMethods;

import io.mart.xml.setter.Messaging;

/**
 * @author Aleksandr Martiushov
 */
public class Communication {
    private io.mart.xml.setter.Messaging messaging;

    public void setMessaging(Messaging messaging) {
        this.messaging = messaging;
    }

    public void communicate(){
        System.out.printf(messaging.communicate());
    }

    public void myInitMethod(){
        System.out.println("Communication: init method myInitMethod is called");
    }

    public void myDestroyMethod(){
        System.out.println("Communication: destroy method myDestroyMethod is called");
    }
}
