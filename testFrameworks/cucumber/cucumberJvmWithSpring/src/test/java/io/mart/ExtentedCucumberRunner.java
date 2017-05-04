package io.mart;

import cucumber.api.junit.Cucumber;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.IOException;

/**
 * @author Aleksandr Martiushov
 */
public class ExtentedCucumberRunner extends Cucumber {

    /**
     * Constructor called by JUnit.
     *
     * @param clazz the class with the @RunWith annotation.
     * @throws IOException         if there is a problem
     * @throws InitializationError if there is another problem
     */
    public ExtentedCucumberRunner(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        //System.out.println("Runner.run(): I just print this from beginning of Runner.run()");
        notifier.addFirstListener(new MyListener());
        super.run(notifier);
    }

    @Override
    public Description getDescription() {
        Description description = super.getDescription();
        //System.out.println("Runner.getDescription(): Class name " + description.getClassName());
        //System.out.println("Runner.getDescription(): Display name " + description.getDisplayName());

        return description;
    }
}