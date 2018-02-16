package io.mart.javacode;

public class JavaWorkerFullTime {

    private final String firstName;
    private final boolean fullTime;

    public JavaWorkerFullTime(String firstName) {
        this.firstName = firstName;
        this.fullTime = true;
    }

    public JavaWorkerFullTime(String firstName, boolean fullTime) {
        this.firstName = firstName;
        this.fullTime = fullTime;
    }
}
