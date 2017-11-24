package io.mart.xml.setter;

/**
 * @author Aleksandr Martiushov
 */
public class MessagingImpl implements Messaging {

    @Override
    public String communicate() {
        return "Sending message\n";
    }
}
