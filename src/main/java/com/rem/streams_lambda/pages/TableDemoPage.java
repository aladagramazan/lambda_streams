package com.rem.streams_lambda.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;

public class TableDemoPage {

    private final WebDriver driver;

    public TableDemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-1.html");
    }

    public void selectRows(Predicate<List<WebElement>> predicate) {
        this.driver.findElements(By.tagName("tr")) // row list
                .stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td"))) // td list
                .filter(tdList -> tdList.size() == 4) // filter out rows with no checkboxes
                .filter(predicate) // gender check
                .map(tdList -> tdList.get(3)) // td containing checkbox
                .map(td -> td.findElement(By.tagName("input"))) // input element
                .forEach(WebElement::click);
    }
}
