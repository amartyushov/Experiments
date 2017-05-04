package io.mart;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Aleksandr Martiushov
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "io.mart",
        features = "classpath:cucumber",
        plugin = {"pretty"}
)
public class CucumberExecutorTest {
}
