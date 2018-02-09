package io.mart.analyser;

import lombok.extern.slf4j.Slf4j;
import org.testng.*;

@Slf4j
public class CustomListener implements ISuiteListener, IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        TimeCounter.started(method, Thread.currentThread().getName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        TimeCounter.finished(method, Thread.currentThread().getName());
    }

    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {
        new HtmlTimeReporter().report(10, 0);
    }
}
