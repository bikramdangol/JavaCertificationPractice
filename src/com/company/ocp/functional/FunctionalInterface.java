package com.company.ocp.functional;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * Created by bikra on 12/23/2019 8:44 PM.
 */
public class FunctionalInterface {
    public static void main(String[] args) {
        Supplier<String> supplier = FunctionalInterface::get;
        System.out.println(supplier.get().length());
        Supplier supplier1 = FunctionalInterface::get;
        System.out.println(supplier1.get());

        // int lambda cant be used for Wrapper functional Interface.
        // BiFunction<Integer, Double, Integer> takeABreak = (int n, double e) -> (int) (n + e);
    }

    private static String get() {
        int x = 5;
        if (x > 5) {
            return null;
        } else {
            return "Bikram";
        }
    }
}
