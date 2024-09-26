package com.rem.streams_lambda;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rem.streams_lambda.pages.TableDemoPage;
import com.rem.streams_lambda.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.StringUtils;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class CheckBoxSelectionTest {

    private WebDriver driver;
    private TableDemoPage tableDemoPage;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.tableDemoPage = new TableDemoPage(this.driver);
    }

    @Test(dataProvider = "criteriaProvider")
    public void tableRowTest(Predicate<List<WebElement>> searchCriteria) {
        this.tableDemoPage.goTo();
        this.tableDemoPage.selectRows(searchCriteria);

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "criteriaProvider")
    public void googleTest(Predicate<List<WebElement>> searchCriteria) {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
        this.driver.findElements(By.tagName("tr")) // row list
                .stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td"))) // td list
                .filter(searchCriteria) // gender check
                .map(tdList -> tdList.get(3)) // td containing checkbox
                .map(td -> td.findElement(By.tagName("input"))) // input element
                .forEach(WebElement::click);

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "criteriaProvider")
    public void googleTest1(Predicate<List<WebElement>> searchCriteria) {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html");
        this.driver.findElements(By.tagName("tr")) // row list
                .stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td"))) // td list
                .filter(tdList -> tdList.size() == 4) // filter out rows with no checkboxes
                .filter(searchCriteria) // gender check
                .map(tdList -> tdList.get(3)) // td containing checkbox
                .map(td -> td.findElement(By.tagName("input"))) // input element
                .forEach(WebElement::click);

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @DataProvider(name = "criteriaProvider")
    public Object[] getGender() {
        Predicate<List<WebElement>> allMale = l -> l.get(1).getText().equalsIgnoreCase("male");
        Predicate<List<WebElement>> allFemale = l -> l.get(1).getText().equalsIgnoreCase("female");
        Predicate<List<WebElement>> allGender = allMale.or(allFemale);
        Predicate<List<WebElement>> allAu = l -> l.get(2).getText().equalsIgnoreCase("au");
        Predicate<List<WebElement>> femaleAu = allFemale.and(allAu);
        return new Object[]{
              allMale, allFemale, allGender, allAu, femaleAu
        };
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
