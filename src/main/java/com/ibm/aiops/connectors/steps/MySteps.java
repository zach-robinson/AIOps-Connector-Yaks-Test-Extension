package com.ibm.aiops.connectors.steps;

import com.consol.citrus.TestCaseRunner;
import com.consol.citrus.annotations.CitrusResource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.consol.citrus.actions.EchoAction.Builder.echo;

public class MySteps {
    @CitrusResource
    private TestCaseRunner runner;

    @Given("^My steps are loaded$")
    public void stepsAreLoaded() {
        runner.given(echo("My steps are loaded"));
    }

    @Then("^I can do whatever I want!$")
    public void doWhateverYouWant() {
        runner.given(echo("I can do whatever I want!"));

    }

    @Then("^I do something else$")
    public void doSomethingElse() {

    }
}
