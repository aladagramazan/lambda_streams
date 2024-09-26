package com.rem.streams_lambda.calculator;

import java.util.function.Function;

public class MainTest {

    public static void main(String[] args) {

        String expression = "5 + 2 - 3 * 7 + 2 / 3"; // 5 + 2 - 3 * 7 + 2 / 3 = 10
        String expression2 = "10 / 2 * 3 - 3 / 3 * 5"; // 10 / 2 * 3 - 3 / 3 * 5 = 20
        String expression3 = "9 * 9 - 1 * 7 / 8 + 30 ^ 2 % 3"; // 9 * 9 - 1 * 7 / 8 + 30 = 100

        Calculator.addOperation("^", (a, b) -> (int) Math.pow(a, b));
        Calculator.addOperation("%", (a, b) -> a % b);

        System.out.println(Calculator.calculate(expression));  //10
        System.out.println(Calculator.calculate(expression2));  //20
        System.out.println(Calculator.calculate(expression3)); // 100
    }
}
