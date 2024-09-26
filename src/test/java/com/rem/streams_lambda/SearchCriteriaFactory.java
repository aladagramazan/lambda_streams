package com.rem.streams_lambda;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class SearchCriteriaFactory {

    private static final Predicate<List<WebElement>> allMale = l -> l.get(1).getText().equalsIgnoreCase("male");
    private static final Predicate<List<WebElement>> allFemale = l -> l.get(1).getText().equalsIgnoreCase("female");
    private static final Predicate<List<WebElement>> allGender = allMale.or(allFemale);
    private static final Predicate<List<WebElement>> allAu = l -> l.get(2).getText().equalsIgnoreCase("au");
    private static final Predicate<List<WebElement>> femaleAu = allFemale.and(allAu);

    private static final Map<String, Predicate<List<WebElement>>> MAP = new HashMap<>();

    static {
        MAP.put("allMale", allMale);
        MAP.put("allFemale", allFemale);
        MAP.put("allGender", allGender);
        MAP.put("allAu", allAu);
        MAP.put("femaleAu", femaleAu);
    }

    public static Predicate<List<WebElement>> getCriteria(String criteria) {
        return MAP.get(criteria);
    }
}
