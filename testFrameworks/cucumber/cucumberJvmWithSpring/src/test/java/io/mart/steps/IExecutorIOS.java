package io.mart.steps;

import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("iOS")
public class IExecutorIOS implements IExecutor {
    public void pressButton() {
        System.out.println("Pressed for iOS");
    }

    public void insertText() {
        System.out.println("Inserted for iOS");
    }
}
