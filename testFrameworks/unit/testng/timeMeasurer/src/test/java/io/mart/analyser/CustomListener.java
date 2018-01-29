package io.mart.analyser;

import org.testng.*;

public class CustomListener implements ISuiteListener, IInvokedMethodListener {


    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        TimeCounter.started(method);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        TimeCounter.finished(method);
    }

    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {
        new HtmlTimeReporter().report(100, 2);
    }
}
