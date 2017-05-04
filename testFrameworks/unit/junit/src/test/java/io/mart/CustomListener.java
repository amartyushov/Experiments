package io.mart;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 * @author Aleksandr Martiushov
 */
public class CustomListener extends RunListener {
    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println("Test run started");
        System.out.println("Test to execute " + description.testCount());

        // execution using @RunWith does not invoke this method
        // only pure execution as in io.mart.PureJUnitExecution does it
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("Test run finished");
        System.out.println("Executed " + result.getRunCount() + " test during " + result.getRunTime());
    }

    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println("Test started " + description.getDisplayName());
    }

    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("Test finished " + description.getDisplayName());
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println("Test failed " + failure.getException());
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println("Test ignored " + description.getDisplayName());
    }
}
