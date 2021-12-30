package com.company.oca.stringOperation;

import java.util.regex.Pattern;

/**
 * Created by bikra on 4/23/2021 6:06 PM.
 */
public class StringOperation {
    public static void main(String[] args) {
        System.out.println("Repeat:");
        String repeat = "HelloWorld ";
        System.out.println(repeat.repeat(3));

        System.out.println("\nLines: ");
        String string = "\nFirst\nSecond\nThird\n";
        string.lines().forEach(System.out::println); // It ignores the last \n but not the first \n.
        System.out.println("End Lines");

        // Pattern to Match Predicate
        var predicate = Pattern.compile("e[0-9][a-z]+").asMatchPredicate();
        String mainString = "e5ither";
        System.out.println("Matched? " + predicate.test(mainString));

    }
}
