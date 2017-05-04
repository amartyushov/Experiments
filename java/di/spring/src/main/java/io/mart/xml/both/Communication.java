package io.mart.xml.both;

import io.mart.xml.constructor.Encryption;
import io.mart.xml.setter.Messaging;

/**
 * @author Aleksandr Martiushov
 */
public class Communication {

    private Messaging messaging;
    private Encryption encryption;

    public Communication(Encryption encryption) {
        this.encryption = encryption;
    }

    public void setMessaging(Messaging messaging) {
        this.messaging = messaging;
    }

    public void communicate(){
        System.out.println(messaging.communicate());
        encryption.encryptData();
    }
}
