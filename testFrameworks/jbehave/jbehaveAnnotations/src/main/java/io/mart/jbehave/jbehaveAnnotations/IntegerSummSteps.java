package io.mart.jbehave.jbehaveAnnotations;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.ArrayList;
import java.util.List;

public class IntegerSummSteps {

    private List<Integer> values = new ArrayList<>();
    private Integer result = 0;

    @Given("integer $value is inserted")
    public void integerInserted(Integer value) {
        values.add(value);

    }
    @When("I summ integers")
    public void summ() {
        for (Integer i : values){
            result +=i;
        }
    }
    @Then("I have $val result")
    public void calculateResult(Integer val) {
        if (result != val) {
            throw new RuntimeException("result is " + val + ", but should be " + result);
        }

    }
}