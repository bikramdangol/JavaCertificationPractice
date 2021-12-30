package com.company.oca.lamda;

import java.util.function.Predicate;

/**
 * Created by bikra on 11/25/2019 7:56 PM.
 */
public class PredicateInAction {
    public void print(Predicate<String> predicate) {
        if (predicate.test("Bikram")) {
            System.out.println("Test pass.");
        } else {
            System.out.println("Test fail.");
        }
    }

    public static void main(String[] args) {
        var temp = "Temp String";
        PredicateInAction predicateInAction = new PredicateInAction();
        predicateInAction.print(a -> a.startsWith("B"));
        predicateInAction.print((a) -> a.contains("ik"));
        predicateInAction.print((var a) -> a.contains("ik")); // use of var
        predicateInAction.print(a -> {return a.contains('r' + "");});
        predicateInAction.print((String a) -> a.indexOf("ram", 3) == 3);
        predicateInAction.print((String a) -> {return a.length() == 6; });
    }
}
