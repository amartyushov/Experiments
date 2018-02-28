package io.mart;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Attachment;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    List<Integer> listOfValues = new ArrayList<Integer>();
    private Integer result = 0;

    @Given("^I enter number (\\d+)$")
    public void i_enter_number(int arg1) throws Throwable {
        addValue(arg1, listOfValues);
    }

    @Attachment
    private int addValue(int val, List<Integer> list) {
        list.add(val);
        return val;
    }

    @When("^I summ numbers$")
    public void i_summ_numbers() throws Throwable {
        for (Integer i : listOfValues){
            result += i;
        }
    }

    @Then("^Result shuold be (\\d+)$")
    public void result_shuold_be(int arg1) throws Throwable {
        assertThat(arg1).isEqualTo(result);
    }

    @Before("@setup")
    public void setup_method() {
        assertThat(1).isEqualTo(1);
    }


    @When("^step from background$")
    public void stepFromBackground() throws Throwable {
        // doing nothing
    }
}
