package io.mart;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        glue = "io.mart",
        features = "classpath:features",
        plugin = {"pretty",
                "html:build/site/cucumber-pretty",
                "json:build/cucumber.json",
                // "ru.yandex.qatools.allure.cucumberjvm.AllureReporter",     // for old way
                //"io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"             // for io.cucumber.cucumber 2.3.1
                "io.qameta.allure.cucumberjvm.AllureCucumberJvm"
        })
//https://github.com/allure-framework/allure-cucumberjvm
@Test
public class CucumberTest extends AbstractTestNGCucumberTests {
}
