package com.selenium.tests;

import com.selenium.framework.pages.ErrorPage;
import com.selenium.framework.pages.FizzBuzzPage;
import com.selenium.framework.pages.OutputPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StepDefinition
{

    @Given("^I am on the Fizzbuzz page$")
    public void i_visit_fizzbuzz()
    {
        FizzBuzzPage.goTo();
    }

    @When("^I process (\\d+)$")
    public void i_process(Integer number)
    {
        FizzBuzzPage.process(number);
    }

    @Then("^I should see \"(.*)\"$")
    public void i_should_see(String output)
    {
        assertThat(OutputPage.output(), is(output));
    }

    @When("^I process zero$")
    public void I_process_zero() throws Throwable {
        FizzBuzzPage.process(0);
    }

    @Then("^the error should be visible$")
    public void the_error_should_be_visible() throws Throwable {
        assertThat(ErrorPage.isVisible(), is(true));
    }

    @And("^the message should be \"([^\"]*)\"$")
    public void the_message_should_be(String message) throws Throwable {
        assertThat(ErrorPage.message(), is(message));
    }
}
