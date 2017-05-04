package io.mart.cucumberJvm;

/**
 * @author Aleksandr Martiushov
 */
public class TestExecutionException extends RuntimeException {

    public TestExecutionException() {
    }

    public TestExecutionException(String message) {
        super(message);
    }

    public TestExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestExecutionException(Throwable cause) {
        super(cause);
    }
}
