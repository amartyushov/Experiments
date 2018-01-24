package io.mart;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter{

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getTestName());
        super.onTestStart(result);
    }

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
    }
}
