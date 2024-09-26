package com.rem.streams_lambda;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("start");
        int total = list.stream()
                .peek(i -> System.out.println("filter: " + i))
                .filter(i -> i % 2 == 0)
                .filter(i -> i > 5)
                .peek(i -> System.out.println("map: " + i))
                .mapToInt(i -> i * i)
                .sum();
        //.forEach(System.out::println);
        System.out.println("total: " + total);
        System.out.println("end");
    }
}
