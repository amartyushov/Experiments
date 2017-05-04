package io.mart;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.mart.extention.CustomRunner;
import org.junit.runner.RunWith;

/**
 * @author Aleksandr Martiushov
 */
@RunWith(CustomRunner.class)
@CucumberOptions(
        glue = "io.mart",
        features = "classpath:cucumber",
        plugin = {"pretty"}
)
public class CucumberExecutorTest {

}
