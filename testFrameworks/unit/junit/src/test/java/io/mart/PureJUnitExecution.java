package io.mart;

import org.junit.runner.JUnitCore;

/**
 * @author Aleksandr Martiushov
 */
public class PureJUnitExecution {

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new CustomListener());
        core.run(SimpleTest.class);
    }
}
