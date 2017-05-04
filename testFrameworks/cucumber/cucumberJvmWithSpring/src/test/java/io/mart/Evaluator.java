package io.mart;

import org.junit.runner.JUnitCore;

/**
 * @author Aleksandr Martiushov
 */
public class Evaluator {

    public static void main(String[] args) {

        // Here I want to check how pure JUnit works with my Listener
        JUnitCore core = new JUnitCore();
        core.addListener(new MyListener());
        core.run(DummyJUnitToExperiment.class);

        // sequence of Listener.testStarted and Listener.testFinished is correct
    }
}
