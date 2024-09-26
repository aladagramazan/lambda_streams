package com.rem.streams_lambda.supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Supplier<WebDriver> chromeSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "/Users/ramazanaladag/drivers/chromedriver-mac-arm64/chromedriver");
        return new ChromeDriver();
    };

    private static final Supplier<WebDriver> firefoxSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", "/Users/ramazanaladag/drivers/geckodriver");
        return new FirefoxDriver();
    };

    private static final Map<String, Supplier<WebDriver>> driverMap = new HashMap<>();

    static {
        driverMap.put("chrome", chromeSupplier);
        driverMap.put("firefox", firefoxSupplier);
    }

    public static WebDriver getDriver(String browser) {
        return driverMap.getOrDefault(browser, chromeSupplier).get();
    }

}