package io.mart;

import cucumber.api.CucumberOptions;

@CucumberOptions(
        glue = "io.mart",
        features = "classpath:cucumber",
        plugin = {"pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json", "junit:target/cucumber.xml"}
)
public class CucumberRunnerTest {
}
