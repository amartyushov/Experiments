package io.mart.javaEight;

/**
 * @author Alexander Martyushov
 */
public interface NewInterface {

    int minus(int val1, int val2);

    default double sqrt(double val) {
        return Math.sqrt(val);
    }
}
