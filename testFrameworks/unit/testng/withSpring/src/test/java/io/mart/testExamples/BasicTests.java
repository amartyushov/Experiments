package io.mart.testExamples;

import io.mart.testExamples.AbstractTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.AssertionErrors;
import org.testng.annotations.Test;

public class BasicTests extends AbstractTest {

    @Test
    public void test1() {
        checker.checkRequest("this is response", executor.doRequest());
    }

    @Test
    public void test2() {
        checker.checkRequest("this is response", executor.doRequest());
    }
}
