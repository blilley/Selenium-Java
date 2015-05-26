package com.selenium.framework.pages;

import com.selenium.framework.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertThat;

public class ErrorPage
{
    public static Boolean isVisible() {
        WebDriverWait wait = new WebDriverWait(Driver.Instance, 20);

        WebElement errorElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error")));

        return errorElement != null;
    }

    public static String message() {
        WebDriverWait wait = new WebDriverWait(Driver.Instance, 20);

        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".errorMessage")));

        return errorMessage.getText();
    }
}
