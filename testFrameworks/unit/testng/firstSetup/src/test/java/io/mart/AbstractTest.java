package io.mart;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({CustomListener.class})
public class AbstractTest {

    //@BeforeClass
    public void parentBeforeClass() {
        System.out.println("@BeforeClass in parent class");
    }

    @BeforeSuite
    public void parentBeforeSuite() {
        System.out.println("@BeforeSuite in parent class");
    }
}
