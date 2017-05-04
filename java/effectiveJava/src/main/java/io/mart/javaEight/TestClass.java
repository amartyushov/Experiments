package io.mart.javaEight;

/**
 * @author Alexander Martyushov
 */
public class TestClass implements Calculator, NewInterface{

    @Override
    public int sum(int val1, int val2) {
        return val1 + val2;
    }


    @Override
    public int minus(int val1, int val2) {
        return val1 - val2;
    }
}
