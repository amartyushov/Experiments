package io.mart.xml.setter;

/**
 * @author Aleksandr Martiushov
 */
public class Communication {
    private Messaging messaging;

    public void setMessaging(Messaging messaging) {
        this.messaging = messaging;
    }

    public void communicate(){
        System.out.printf(messaging.communicate());
    }
}
