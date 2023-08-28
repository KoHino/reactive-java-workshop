package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(num -> System.out.println(num));

        // Get the value from the Mono into an integer variable
        Integer value = ReactiveSources.intNumberMono().block();

        System.out.println(value);
    }

}
