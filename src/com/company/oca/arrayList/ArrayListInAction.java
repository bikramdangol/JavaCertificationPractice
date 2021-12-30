package com.company.oca.arrayList;

import java.util.*;/*ArrayList;
import java.util.List;*/

/**
 * Created by bikra on 11/26/2019 3:52 PM.
 */
public class ArrayListInAction {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.remove(1);
        // see item can be added at the end using index.
        list.add(2,"Four"); // It add the element at the end though the size is only 2 at this moment.
        // list.add(7,"Four"); It throws IndexOutOfBoundsException
        // list.sort(); // You need a Comparator.
        list.sort(Comparator.naturalOrder());
        Collections.sort(list);
        Collections.sort(list, Comparator.naturalOrder());
        System.out.println(list);

        System.out.println("Returns if boolean to indicate if removed: " + list.removeIf(item -> item.equals("One")));
        // List doesn't have .filter method.
        list.stream().filter(item -> !item.equals("Three"));
        System.out.println(list);

        List<Object> listOfString = Arrays.asList("H", "E");
        Integer[] intArray = new Integer[] {1,2,3};
        Object[] objArray = intArray;
        //objArray[0] = new Object(); // throws ArrayStoreException

    }
}
