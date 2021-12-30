package com.company.ocp.collection;

import java.util.*;

/**
 * Created by bikra on 12/15/2019 9:47 AM.
 */
public class CollectionBasics {
    public static void processArray(String[] namesArray) {

    }
    public static void main(String[] args) {
        String[] array = {"Bikram", "Anup", "Shova", "Bipra"};
        // It doesn't have array.sort/filter
        // Use Arrays.sort()
        List<String> list = Arrays.asList(array); // returns fixed size list
        list.set(3, "Binit");
        array[0] = "Siddhi";
        String[] array2 = (String[]) list.toArray();
        //list.remove(1); // throws UnsupportedOperationException
        List<String> list2 = new ArrayList<>(list);
        list2.add("Ishwori");
        String[] arraryFromList = list2.toArray(new String[5]);
        list2.add("addedAfter");

        Arrays.sort(array);
        System.out.println("Banana index: " + Arrays.binarySearch(array, "Banana"));

        int[] numbers = {6,9,1,8};
        Arrays.sort(numbers);
        System.out.println("Number 6 index: " + Arrays.binarySearch(numbers, 6)); // 1
        System.out.println("Number 3 index: " + Arrays.binarySearch(numbers, 3)); // -2

        List<String> nameList = Arrays.asList("Mike", "John", "Justin", "Bruce");
        //List<String> nameList1 = Arrays.asList({"Mike", "John", "Justin", "Bruce"}); // {} can be used only to initialize the Array.
        //processArray({"Mike", "John", "Justin", "Bruce"});// array initialization not allowed.
        processArray((String[])nameList.toArray());


        List<Integer> numbersList = Arrays.asList(9,7,5,3);
        //numbersList.sort(Comparator); // Comparator is required.
        Collections.sort(numbersList);
        System.out.println(Collections.binarySearch(numbersList, 3)); // 0
        System.out.println(Collections.binarySearch(numbersList, 2)); //-1

        numbersList.removeIf(n -> n > 8);

        Set<String> s = new HashSet<>();
        s.add("lion");
        s.add("tiger");
        s.add("bear");
        // note used variable can't be used in lambda.
        //s.forEach(nameList-> System.out.println(nameList));

    }
}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
