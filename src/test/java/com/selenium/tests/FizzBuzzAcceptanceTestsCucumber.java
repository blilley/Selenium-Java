package com.selenium.tests;

import com.selenium.framework.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty"})
public class FizzBuzzAcceptanceTestsCucumber
{
    @Before
    public static void setup()
    {
        Driver.Initialize();
    }

    @After
    public static void cleanUp()
    {
        Driver.Close();
    }

}
