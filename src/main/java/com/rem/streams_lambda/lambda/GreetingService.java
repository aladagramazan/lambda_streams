package com.rem.streams_lambda.lambda;

//SAM --> Single Abstract Method
@FunctionalInterface
public interface GreetingService {

    void sayMessage(String firstname);

    //A @FunctionalInterface in Java is an interface that has exactly one abstract method
}
