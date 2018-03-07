package io.mart.tests;

import io.mart.tests.AbstractTestClass;
import org.testng.annotations.Test;

public class SimpleTest extends AbstractTestClass {

    @Test
    public void test1() {
        checker.responseCorrect("my response", executor.getResponse());
    }

    @Test
    public void test2() {
        checker.responseCorrect("from reference testing", executor.getValue());
    }

    @Test
    public void test3() {
        checker.responseCorrect("localhost", executor.getGradleProp());
    }

}
