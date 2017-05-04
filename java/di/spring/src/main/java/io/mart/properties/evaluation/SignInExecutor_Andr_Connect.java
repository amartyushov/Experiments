package io.mart.properties.evaluation;

import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("ANDROID_CONNECT")
public class SignInExecutor_Andr_Connect implements SignInExecutor {

    public void setCustomerId(String id) {
        System.out.println("Was set for ANDROID CONNECT");
    }

    public void pressLogin() {
        System.out.println("Was pressed by ANDROID CONNECT");
    }
}
