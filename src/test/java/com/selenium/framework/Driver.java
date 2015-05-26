package com.selenium.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver
{
    public static WebDriver Instance;

    public static String BaseAddress = "http://localhost:8080/";

    public static void Initialize()
    {
        Instance = new FirefoxDriver();
        TurnOnWait();
    }

    public static void Close()
    {
        Instance.quit();
    }

    private static void TurnOnWait()
    {
        Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
