package com.selenium.framework.pages;

import com.selenium.framework.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutputPage
{
    public static String output()
    {
        WebDriverWait wait = new WebDriverWait(Driver.Instance, 20);

        WebElement outputElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".outputValue")));

        return outputElement.getText();
    }
}
