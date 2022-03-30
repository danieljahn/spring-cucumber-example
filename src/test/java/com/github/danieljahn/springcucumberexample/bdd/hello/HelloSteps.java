package com.github.danieljahn.springcucumberexample.bdd.hello;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;

public class HelloSteps {

    @Autowired
    private HelloClient client;

    @When("I request to greet {string}")
    public void iRequestToGreet(String name) {
        System.out.println(MessageFormat.format("iAskToGreet {0}", name));
        client.requestGreeting(name);
    }

    @Then("The response code is {int}")
    public void theResponseCodeIs(int responseCode) {
        client.assertRepsonseCode(responseCode);
    }

    @Then("The body field {string} is {string}")
    public void theBodyFieldIs(String fieldName, String expectedValue) {
        client.assertBodyField(fieldName, expectedValue);
    }
}
