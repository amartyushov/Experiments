package io.mart;

import org.testng.Assert;

public class Checker {

    public void responseCorrect(String expected, String actual) {
        Assert.assertTrue(expected.equals(actual), "response is not correct");
    }
}
