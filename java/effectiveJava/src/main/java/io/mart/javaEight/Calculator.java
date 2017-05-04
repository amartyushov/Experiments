package io.mart.javaEight;

/**
 * @author Alexander Martyushov
 */

public interface Calculator {

    int sum(int val1, int val2);

    default double sqrt(int val) {
        return Math.sqrt(val);
    }
}
