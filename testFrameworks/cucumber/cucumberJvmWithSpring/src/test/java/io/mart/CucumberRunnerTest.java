package io.mart;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.junit.runner.RunWith;

@RunWith(ExtentedCucumberRunner.class)
@CucumberOptions(
        glue = "io.mart",
        features = "classpath:cucumber",
        plugin = {"pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json", "junit:target/cucumber.xml"},
        //plugin = {"io.mart.CustomFormatter"}, If you need to use custome formatter - uncomment
        snippets = SnippetType.UNDERSCORE,
        junit = "--allow-started-ignored"
)
public class CucumberRunnerTest {

}