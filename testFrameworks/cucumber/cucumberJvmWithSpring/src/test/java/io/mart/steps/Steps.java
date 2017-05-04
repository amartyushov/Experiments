package io.mart.steps;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * @author Aleksandr Martiushov
 */
public class Steps extends AbstractSteps {
    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    private IExecutor executor = (IExecutor) context.getBean("app");

    @Given("^first step$")
    public void first_step() throws Throwable {
        //System.out.println("[STEP DEFINITION] I can read scenario name in Runtime " + scenario.getName());
        executor.insertText();
    }

    @Then("^Last step$")
    public void last_step() throws Throwable {
        //System.out.println("[STEP DEFINITION] I can read scenario name in Runtime " + scenario.getName());
        executor.pressButton();
    }

}
