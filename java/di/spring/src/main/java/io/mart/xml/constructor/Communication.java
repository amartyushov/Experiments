package io.mart.xml.constructor;

/**
 * @author Aleksandr Martiushov
 */
public class Communication {

    private Encryption encryption;

    public Communication(Encryption encryption) {
        this.encryption = encryption;
    }

    public void communicate(){
        encryption.encryptData();
    }
}
