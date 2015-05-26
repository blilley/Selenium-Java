package com.selenium.tests;

import com.selenium.framework.Driver;
import com.selenium.framework.pages.ErrorPage;
import com.selenium.framework.pages.FizzBuzzPage;
import com.selenium.framework.pages.OutputPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzAcceptanceTestsFramework
{
    @BeforeClass
    public static void openBrowser()
    {
        Driver.Initialize();
        FizzBuzzPage.goTo();
    }

    @Test
    public void GivenFizzBuzz_WhenIProcess1_ThenItReturns1()
    {
        FizzBuzzPage.process(1);

        assertThat(OutputPage.output(), is("1"));
    }

    @Test
    public void GivenFizzBuzz_WhenIProcess3_ThenItReturnsFizz()
    {
        FizzBuzzPage.process(3);

        assertThat(OutputPage.output(), is("Fizz"));
    }

    @Test
    public void GivenFizzBuzz_WhenIProcessValueLessThan1_ThenItReturnsError()
    {
        FizzBuzzPage.process(0);

        assertThat(ErrorPage.isVisible(), is(true));
        assertThat(ErrorPage.message(), is("Input cannot be less than 1"));
    }

    @AfterClass
    public static void closeBrowser()
    {
        Driver.Close();
    }
}
