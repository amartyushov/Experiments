package io.mart.stepDefinitions.simple;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.mart.Utils;
import io.mart.cucumberJvm.MyWorld;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Aleksandr Martiushov
 */
public class StepsForException {

    MyWorld myWorld = new MyWorld();

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Then("the user gets a Null pointer exception$")
    public void null_exception_thrown() throws Throwable {
        expectedEx.expect(IOException.class);
        //expectedEx.expectMessage("the message");
        Utils.throwException(IOException.class);
    }

    @And("a failure is expected")
    public void a_failure_is_expected() {
        myWorld.expectException();
    }

    @When("you attempt something illegal")
    public void you_attempt_something_illegal() throws InstantiationException, IllegalAccessException {
        try {
            Utils.throwException(RuntimeException.class);
        } catch (RuntimeException e) {
            myWorld.add(e);
        }
    }

    @And("it fails")
    public void it_fails() {
        assertThat(myWorld.getExceptions()).isNotEmpty();
        assertThat(myWorld.exceptionMessage()).contains("Exception message");
    }
}
