package io.mart;

import org.testng.*;

import java.util.Arrays;

public class MyListener extends TestListenerAdapter implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("happens in very end");
        Arrays.stream(getAllTestMethods())
                .distinct()
                .forEach(method -> {
                    System.out.println(method.getQualifiedName() + "COUNT: " + invocationCount(method));
                });
    }

    private Long invocationCount(ITestNGMethod m) {
        return Arrays.stream(getAllTestMethods()).filter(method -> method.getQualifiedName().equalsIgnoreCase(m.getQualifiedName())).count();
    }
}
