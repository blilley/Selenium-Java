package com.selenium.framework.pages;

import com.selenium.framework.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FizzBuzzPage {

    public static void goTo() {
        Driver.Instance.navigate().to(Driver.BaseAddress);
    }

    public static void process(int number)
    {
        WebDriverWait wait = new WebDriverWait(Driver.Instance, 20);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=number]")));

        element.clear();
        element.sendKeys(String.valueOf(number));

        WebElement buttonElement = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("button")));

        buttonElement.click();
    }
}

