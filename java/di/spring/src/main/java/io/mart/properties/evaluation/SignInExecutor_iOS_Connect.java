package io.mart.properties.evaluation;

import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("iOS_CONNECT")
public class SignInExecutor_iOS_Connect implements SignInExecutor {
    public void setCustomerId(String id) {
        System.out.println("Was set for iOS CONNECT");
    }

    public void pressLogin() {
        System.out.println("Was pressed by iOS CONNECT");
    }
}
