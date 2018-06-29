package io.mart;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.testng.TestNGCourgette;
import cucumber.api.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CourgetteOptions(
        threads = 1,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = false,
        showTestOutput = true,
        reportTargetDir = "build/chrome",
        cucumberOptions = @CucumberOptions(
                features = "classpath:features",
                glue = "io.mart",
                tags = {"@regression"},
                plugin = {"pretty", "io.qameta.allure.cucumberjvm.AllureCucumberJvm"},
                strict = true
        ))
public class CucumberTest extends TestNGCourgette {
}