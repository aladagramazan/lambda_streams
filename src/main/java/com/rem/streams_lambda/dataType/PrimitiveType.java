package com.rem.streams_lambda.dataType;

public class PrimitiveType {

    public static void main(String[] args) {
        int i = 5;
        System.out.println("Before changeValue: " + i);
        changeValue(i);
        System.out.println("After changeValue: " + i);
        /*
        In Java, primitive types like int are passed by value,
        meaning a copy of the variable is passed to methods.
        Changes to the parameter inside the method do not affect the original variable.
         */
    }

    private static void changeValue(int i) {
      i++;
    }
}
