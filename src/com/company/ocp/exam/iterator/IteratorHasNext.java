package com.company.ocp.exam.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bikra on 4/24/2021 11:14 PM.
 */
public class IteratorHasNext {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("A", "B");

        for (String x: names) {
            System.out.println(x);
        }

        System.out.println();

        Iterator<String> itr = names.listIterator();
        while(itr.hasNext()) {
            System.out.println(itr.next().toLowerCase());
        }

        System.out.println();
        int i = 0;
        Iterator<String> itr2 = names.iterator();
        for(; itr2.hasNext();) {
            System.out.println(itr2.next());
        }
    }
}
