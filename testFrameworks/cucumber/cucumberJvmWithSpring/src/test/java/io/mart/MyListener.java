package io.mart;

import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

/**
 * @author Aleksandr Martiushov
 */
//@RunListener.ThreadSafe
public class MyListener extends RunListener {

    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println("MY: test run started");
    }

    @Override
    public void testStarted(Description description) throws Exception {
        // Strange issue is that I see these lines after step is executed, as if it is testFinished()
        //System.out.println("MY: test started");
        //System.out.println("MyListener.testStarted: method name " + description.getMethodName());
        //System.out.println("MyListener.testStarted: display name " + description.getDisplayName());
        System.out.println(description.getDisplayName());
    }

    @Override
    public void testFinished(Description description) throws Exception {
        /*System.out.println("MY: test finished");
        System.out.println("MyListener.testFinished: method name " + description.getMethodName());
        System.out.println("MyListener.testFinished: display name " + description.getDisplayName());*/
    }
}
