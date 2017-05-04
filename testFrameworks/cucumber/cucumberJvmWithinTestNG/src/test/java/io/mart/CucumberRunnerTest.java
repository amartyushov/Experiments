package io.mart;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "io.mart",
        features = "classpath:cucumber",
        tags = {"~@exclude", "~@failed", "~@mobile"},
        plugin = {"pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json"}
)
public class CucumberRunnerTest {
}