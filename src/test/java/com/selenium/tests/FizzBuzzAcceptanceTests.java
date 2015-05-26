package com.selenium.tests;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class FizzBuzzAcceptanceTests
{
    private static RemoteWebDriver driver;

    @BeforeClass
    public static void openBrowser()
    {
//        System.setProperty("webdriver.chrome.driver", "c:\\ChromeDriver\\chromedriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:8080");
    }

    @Test
    public void GivenAFizzBuzzSite_WhenLoaded_ThenICanEnterANumber()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=number]")));

        String value = "1";
        enterNumber(element, value);

        assertNotNull(element);
    }

    private void enterNumber(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    @Test
    public void GivenFizzBuzz_WhenIProcess1_ThenItReturns1()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=number]")));

        enterNumber(element, "1");

        WebElement buttonElement = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("button")));

        buttonElement.click();

        WebElement outputElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".outputValue")));

        assertThat(outputElement.getText(), is("1"));

    }

    @Test
    public void GivenFizzBuzz_WhenIProcessValueLessThan1_ThenItReturnsError()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=number]")));

        enterNumber(element, "0");

        WebElement buttonElement = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("button")));

        buttonElement.click();

        WebElement outputElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".errorMessage")));

        assertThat(outputElement.getText(), is("Input cannot be less than 1"));

    }

    @AfterClass
    public static void closeBrowser()
    {
        driver.quit();
    }
}
