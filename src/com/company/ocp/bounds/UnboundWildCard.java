package com.company.ocp.bounds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bikra on 12/15/2019 11:45 AM.
 */
public class UnboundWildCard {
    public static void printList(List<?> list) {
        // list.add("Add more not possible.");
        for (Object x: list) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("Java");
        printList(keywords);
    }
}
