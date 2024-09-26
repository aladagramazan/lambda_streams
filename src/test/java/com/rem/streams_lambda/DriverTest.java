package com.rem.streams_lambda;

import com.rem.streams_lambda.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.util.StringUtils;
import org.testng.annotations.*;

import java.util.Locale;


public class DriverTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void googleTest() {
        this.driver.get("https://google.com/");
        this.driver.findElements(By.tagName("a"))
                .stream()
                .map(WebElement::getText)
                .map(StringUtils::trimAllWhitespace)
                .filter(StringUtils::hasText)
                .filter(e -> !e.toLowerCase(Locale.ROOT).contains("s"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void googleTestForNotContainsTagName() {
        this.driver.get("https://google.com/");
        this.driver.findElements(By.tagName("afekgekgmnege"))
                .stream()
                .map(WebElement::getText)
                .map(StringUtils::trimAllWhitespace)
                .filter(StringUtils::hasText)
                .filter(e -> !e.toLowerCase(Locale.ROOT).contains("s"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // if nothing elements in the list, not doing anything
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
