package io.mart.stepDefinitions.simple;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StepDefinitions {

    List<Integer> listOfValues = new ArrayList<Integer>();
    private Integer result = 0;

    @Given("^I enter number (\\d+)$")
    public void i_enter_number(int arg1) throws Throwable {
        listOfValues.add(arg1);
    }

    @When("^I summ numbers$")
    public void i_summ_numbers() throws Throwable {
        for (Integer i : listOfValues){
            result += i;
        }
    }

    @Then("^Result shuold be (\\d+)$")
    public void result_shuold_be(int arg1) throws Throwable {
        assertThat(result, is(arg1));
    }




}
