package io.mart;/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class FirstTestClass extends AbstractTest{

    //@BeforeClass
    public void parentBefore() {
        System.out.println("@BeforeClass in child class");
    }

    @Test
    public void firstTest() {
        System.out.println("test from FirstTestClass");
    }
}