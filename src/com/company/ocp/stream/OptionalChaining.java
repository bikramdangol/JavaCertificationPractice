package com.company.ocp.stream;

import java.util.Optional;

/**
 * Created by bikra on 12/16/2019 9:24 PM.
 */
public class OptionalChaining {
    public static void main(String[] args) {
        // chaining
        System.out.println();
        Optional<Integer> integerOptional = Optional.of(234);
        //Optional<Integer> integerOptional = Optional.of(23);
        //Optional<Integer> integerOptional = Optional.empty();
        integerOptional.map(x -> "" + x)
                .filter(x -> x.length() == 3)
                .ifPresent(System.out::println);

        Optional<String> stringOptional = integerOptional.map(x -> "" + x)
                .filter(x -> x.length() == 3);
        System.out.println(stringOptional);
    }
}
