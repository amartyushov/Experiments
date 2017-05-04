package io.mart.extention;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

/**
 * @author Aleksandr Martiushov
 */
public class CustomListener extends RunListener {

    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println("Listener.testStarted: executed " + description.getDisplayName());
    }

    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("Listener.testFinished: executed " + description.getDisplayName());
    }
}
