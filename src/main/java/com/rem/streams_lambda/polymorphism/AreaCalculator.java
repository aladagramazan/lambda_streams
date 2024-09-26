package com.rem.streams_lambda.polymorphism;

import lombok.Builder;

@Builder
public class AreaCalculator {

    //square
    public int calculateArea(int side) {
        return side * side;
    }

    public double calculateArea(double side) {
        return side * side;
    }

    public int calculateArea(int length, int width) {
        return length * width;
    }
}
