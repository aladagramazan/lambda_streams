package com.rem.streams_lambda;

import com.rem.streams_lambda.supplier.DriverFactory;
import com.rem.streams_lambda.util.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class BrokenLinkTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void linkSrcTest() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        List<String> srcList = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getAttribute("src"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .toList();

        Assert.assertEquals(srcList.size(), 0, srcList.toString());
    }

    @Test
    public void linkHrefTest() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .map(e -> e.getAttribute("href"))
                .map(href -> href.startsWith("http://") ? href.replace("http://", "https://") : href)
                .forEach(href -> {
                    System.out.println(href + " : " + LinkUtil.getResponseCode(href));
                });
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
