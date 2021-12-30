package com.company.ocp.bounds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bikra on 12/15/2019 1:25 PM.
 */
public class UpperBoundedWildCards {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        List<? extends Number> list = numbers;
        //  list.add(new Integer(5)); // doesn't compile.
        //It becomes immutable though you can remove items.
        list.remove(1);
        numbers.forEach(x -> System.out.println(x));
    }
}
