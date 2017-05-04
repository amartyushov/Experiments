package io.mart;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Aleksandr Martiushov
 */
public class StepDefinitions {

    private List<Integer> arguments = new ArrayList<Integer>();
    private Integer result = 0;

    @Then("^sum is (\\d+)$")
    public void sumIs(int expectedResult) throws Throwable {
        assertTrue(result == expectedResult);
    }

    @Given("^I input (\\d+)$")
    public void iInput(int inputParameter) throws Throwable {
        arguments.add(inputParameter);
    }

    @When("^I sum$")
    public void iSum() throws Throwable {
        for (Integer i : arguments){
            result += i;
        }
    }
}
