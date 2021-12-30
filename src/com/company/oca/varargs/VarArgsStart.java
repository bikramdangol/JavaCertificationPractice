package com.company.oca.varargs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bikra on 11/25/2019 4:23 PM.
 */
public class VarArgsStart {
    /***
     *
     * @param x
     * @param args
     */
    public void makeNoise(String x, String... args) {
        System.out.println("Method with Varargs...");
    }

    public void makeNoise(String x, String y, String[] args) {
        System.out.println("Method with Array...");
    }

    public void makeNoise(String x, String y) {
        System.out.println("Method with two String");
    }

    // TODO:- 1/25/2020
    public static void main(String[] args) {
        VarArgsStart varArgsStart = new VarArgsStart();
        varArgsStart.makeNoise("a", "b");
        varArgsStart.makeNoise("a", "b", "c");
        varArgsStart.makeNoise("a", "b", new String[] {"c","d"});

        heapPollution();
    }

    private static void heapPollution() {
        some(Arrays.asList("Hello", "World"));
        List<String> listOfString = new ArrayList<>();
        listOfString.add("1");
        List<String>[] stringListArray = new List[] { listOfString };
        some1(stringListArray);
    }

    private static void some(List<String>... values) {
        /*Object[] objectArray = values;
        objectArray[0] = Arrays.asList(1, 2, 3);*/
        for (List<String> value : values) {
            value.stream().forEach(v->System.out.println(v));
        }

    }

    private static void some1(List<String>[] values) {
        /*Object[] objectArray = values;
        objectArray[0] = Arrays.asList(1, 2, 3);*/
        for (List<String> value : values) {
            value.stream().forEach(v->System.out.println(v));
        }

    }
}
