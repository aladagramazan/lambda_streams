package com.rem.streams_lambda.distinct;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Distinct {

    public static void main(String[] args) {
        List<Product> productList = getProductList();
        List<Product> distinctProductList = getDistinctProductList(productList);
        System.out.println(distinctProductList);
    }



    private static List<Product> getDistinctProductList(List<Product> productList) {
        return productList.stream()
                .peek(i -> System.out.println("sorted: " + i))
                .sorted(Comparator.comparing(Product::getProductId))
                .peek(i -> System.out.println("filter: " + i))
                .filter(distinctByKey(Product::getProductName))
                .peek(i -> System.out.println("map: " + i))
                .toList();
    }

    private static <T>Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }



    private static List<Product> getProductList() {
        return List.of(
                Product.builder().productId(4).productName("Apple").build(),
                Product.builder().productId(3).productName("Banana").build(),
                Product.builder().productId(3).productName("Apple").build(),
                Product.builder().productId(1).productName("Banana").build(),
                Product.builder().productId(1).productName("Apple").build()
        );
    }
}
