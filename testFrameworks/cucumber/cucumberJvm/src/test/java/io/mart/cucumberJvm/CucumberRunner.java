package io.mart.cucumberJvm;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "io.mart",
        features = "classpath:features",
        tags = {"~@exclude", "~@failed", "~@not_impl"},
        plugin = {"pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json"})
public class CucumberRunner {
}
