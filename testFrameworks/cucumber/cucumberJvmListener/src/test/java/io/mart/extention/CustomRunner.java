package io.mart.extention;

import cucumber.api.junit.Cucumber;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.IOException;

/**
 * @author Aleksandr Martiushov
 */
public class CustomRunner extends Cucumber {
    /**
     * Constructor called by JUnit.
     *
     * @param clazz the class with the @RunWith annotation.
     * @throws IOException                         if there is a problem
     * @throws InitializationError if there is another problem
     */
    public CustomRunner(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(new CustomListener());
        super.run(notifier);
    }
}
