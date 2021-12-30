package com.company.ocp;

import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * Created by bikra on 12/25/2019 2:51 PM.
 */
public class TestQuestion {
    private int numberMinutes;
    public TestQuestion(int n) {
        numberMinutes = n;
    }
    public int getNumberMinutes() {
        return numberMinutes;
    }

    public static int getNumber(TestQuestion q) {
        return 5;
    }
    public static void main(String[] args) {
        Stream<TestQuestion> runners = Stream.of(new TestQuestion(183), new TestQuestion(161), new TestQuestion(201));
        // check object method reference. It seems no argument is passed, but it is not.
        OptionalInt opt = runners.mapToInt(TestQuestion::getNumber)
                .peek(System.out::println).max();
    }
}
