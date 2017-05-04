package io.mart.steps;

import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Martiushov
 */
@Component("ANDROID")
public class IExecutorAndroid implements IExecutor {
    public void pressButton() {
        //System.out.println(Math.sqrt(9d));
        System.out.println("Pressed for Android");
    }

    public void insertText() {
        //System.out.println(Math.sqrt(81d));
        System.out.println("Inserted for Android");
    }
}
