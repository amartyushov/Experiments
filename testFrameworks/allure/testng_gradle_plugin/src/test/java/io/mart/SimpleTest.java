package io.mart;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void test() {
        System.out.println("This is a test");
    }

    @Test
    public void testAssertion() {
        Assert.assertTrue(false);
    }

    @Test
    public void test2() {
        throw new RuntimeException("my exception");
    }
}
