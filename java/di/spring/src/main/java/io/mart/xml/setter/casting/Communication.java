package io.mart.xml.setter.casting;

/**
 * @author Aleksandr Martiushov
 */
public class Communication implements ICommunication {
    private Messaging messaging;
    private String commType;

    public void setMessaging(Messaging messaging) {
        this.messaging = messaging;
    }

    public void setCommType(String commType) {
        this.commType = commType;
    }

    public String getCommType() {
        return commType;
    }

    public void communicate(){
        System.out.printf(messaging.communicate());
    }
}
