package com.company.oca.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bikra on 4/24/2021 5:35 PM.
 */
public class ListUnmodifiable {
    public static void main(String[] args) {
        List<String> mutableList = new ArrayList<>();
        mutableList.add("Hello");
        mutableList.add("World");
        List<String> unmodifiable = Collections.unmodifiableList(mutableList);
        mutableList.add("Friend");
        // unmodifiable.add("Hi");
        System.out.println(mutableList.equals(unmodifiable));

        List<String> mutableList1 = new ArrayList<>();
        mutableList1.add("Hello");
        mutableList1.add("World");
        mutableList1.add("Friend");

        System.out.println(mutableList.equals(mutableList1));
    }
}
