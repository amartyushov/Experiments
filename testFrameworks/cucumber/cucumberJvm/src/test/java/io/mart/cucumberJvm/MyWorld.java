package io.mart.cucumberJvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksandr Martiushov
 */
public class MyWorld {
    private boolean expectException;
    private List<RuntimeException> exceptions = new ArrayList<>();

    public void expectException() {
        expectException = true;
    }

    public void add(RuntimeException e) {
        if (!expectException) {
            throw e;
        }
        exceptions.add(e);
    }

    public List<RuntimeException> getExceptions() {
        return exceptions;
    }

    public String exceptionMessage(){
        return getExceptions().get(0).getMessage();
    }
}
