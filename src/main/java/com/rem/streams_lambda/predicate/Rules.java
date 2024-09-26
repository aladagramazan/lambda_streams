package com.rem.streams_lambda.predicate;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Predicate;

public class Rules {

    private static Predicate<WebElement> isNotBlank = (e) -> !e.getText().trim().isEmpty();
    private static Predicate<WebElement> hasNotS = (e) -> !e.getText().toLowerCase().contains("s");

    public static List<Predicate<WebElement>> getRules() {
        return List.of(isNotBlank, hasNotS);
    }

    public static Predicate<WebElement> getRule() {
        return isNotBlank.and(hasNotS);
    }
}
