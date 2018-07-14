package io.mart;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        glue = "io.mart",
        features = "classpath:features",
        plugin = {"pretty", "io.qameta.allure.cucumberjvm.AllureCucumberJvm"})
@Test
public class CucumberTest extends AbstractTestNGCucumberTests {
}
