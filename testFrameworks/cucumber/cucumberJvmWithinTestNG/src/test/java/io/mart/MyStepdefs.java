package io.mart;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Aleksandr Martiushov
 */
public class MyStepdefs {

    List<Integer> numbers = new ArrayList<Integer>();
    Integer result = 0;

    @Given("^Number is (\\d+)$")
    public void numberIs(int arg0) throws Throwable {
        numbers.add(arg0);
    }


    @When("^I sum numbers$")
    public void iSumNumbers() throws Throwable {
        for (Integer i : numbers){
            result += i;
        }
    }

    @Then("^I get (\\d+)$")
    public void iGet(int arg0) throws Throwable {
        assertThat(arg0).isEqualTo(result);
    }
}
