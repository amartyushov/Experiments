package io.mart;

import io.mart.cucumberJvm.TestExecutionException;

import java.io.IOException;

/**
 * @author Aleksandr Martiushov
 */
public class Utils {

    public static void throwException(Class s) throws IllegalAccessException, InstantiationException {
        TestExecutionException e = new TestExecutionException("Exception message", (Throwable) s.newInstance());
        throw e;
    }

    public static void main(String[] args) throws Throwable {
        throwException(NullPointerException.class);
    }
}
