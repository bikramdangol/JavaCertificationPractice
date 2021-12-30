package com.company.ocp.optionCheck;

import java.util.Optional;

/**
 * Created by bikra on 12/16/2019 1:51 PM.
 */
public class OptionalCheck {

    public static void main(String[] args) {

        // You can not set null in Optional.of(); Throws null Exception.
        //Optional<String> opt = Optional.of(null);
        //System.out.println("Is present?: " + opt.isPresent());
        // Use Factory Method(of or empty) to create Optional.
        Optional<Double> nullData = null;
        // System.out.println(nullData.isPresent()); // null exception.
        // Optional<Double> valueData = 2.0;

        Optional<Double> optWithValue = Optional.of(2.0);
        System.out.println("Print value: " + optWithValue); // Optional[2.0]
        Optional<Double> optEmpty = Optional.empty();
        System.out.println("Print empty: " + optEmpty); // Optional.empty
        System.out.println("Get Actual value: " + optWithValue.get());

        System.out.println("\nHas Value for non-empty: " + optWithValue.isPresent()); // true
        System.out.println("Has value for empty: " + optEmpty.isPresent()); // false

        System.out.print("\nPrinting using ifPresent and Consumer: ");
        optWithValue.ifPresent(System.out::println); // 2.0
        optWithValue.ifPresent(x -> {x = x + 1; System.out.println(x);});

        String name = null;
        Optional<String> nullableOptional = Optional.ofNullable(name);
        System.out.println("\nis present on null value: " + nullableOptional.isPresent()); // false
        System.out.println("is Empty on null value: " + nullableOptional.isEmpty()); // true
        System.out.println("print null value: " + nullableOptional); // Optional.empty
        // System.out.println("value of null: " + nullableOptional.get() ); // get exception.
        System.out.println("as value is null we can get substitute: " + nullableOptional.orElse("default"));

        System.out.println("\nGet NaN if empty: " + optEmpty.orElse(Double.NaN));
        System.out.println("Get Random if empty: " + optEmpty.orElseGet(Math::random)); // Supplier
        //System.out.println("Throw Exception " + optEmpty.orElseThrow(IllegalStateException::new));

        System.out.println();
        Optional<Integer> intOptional = Optional.of(234);
        System.out.println("See what it returns after map:");
        Optional<String> stringOptionalFromMap = intOptional.map(x -> "Added" + x);
        System.out.println(stringOptionalFromMap); // Optional[Added234]

        // process on the value not on Optional Wrapper. But returns Optional on each operation
        intOptional.map(x -> "" + x)
                .filter(x ->  x.length() == 3)
                .ifPresent(System.out::println);
        intOptional.filter(x ->  x > 200)
                .ifPresent(System.out::println);

        // Question

        // It shows Optional has filter, map, ifPresent methods. ifPresent provides value not optional to the Consumer.
        Optional<String> stringOptional = Optional.of("Hello World");
        stringOptional.filter(y -> ! y.isEmpty())
                .map(y -> 8)
                .ifPresent(System.out::println);
    }
}
