package com.company.oca.array;

import java.util.*;

/**
 * Created by bikra on 1/1/2020 3:23 PM.
 */
public class ArrayPractice {
    public int indexOf(String[] names, String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                System.out.println(i);
                return i;
            }
            System.out.println("a");
            return -1;
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] array = {1,3,4,5};

        int[] array1 = new int[]{2,4,6};
        int[] array2 = new int[3];
        int[] array0 = new int[0];
        // array0[0] = 1; // ArrayIndexOutOfBoundsException
        array2[0] = 3;
        array2[1] = 6;
        array2[2] = 9;

        int[][] array3 =new int[1][]; // you can define second array size later.
        array3[0] = array2;
        array3[0][0] = 5;

        array1 = array;
        System.out.println(array1[3]);

        // Arrays.toString prints the content of 1D
        System.out.println("Arrays toString: " + Arrays.toString(array));
        // Arrays.toString prints Object's toString.
        System.out.println(Arrays.toString(array3));

        // Array has no .filter and .removeIf

        Integer i = 10;
        Short s = 5;
        String sum = (i + s) + "";

        List<String> names = new ArrayList<>();
        names.add("Hello");
        names.add("world");
        // sort of list using Collections.sort and list.sort
        Collections.sort(names);
        names.sort(Comparator.naturalOrder());
        // toArray() gives Object[] and can't be cast to String[]
        // String[] namesArray = (String[]) names.toArray(); // Exception at runtime.
        String[] namesArray = names.toArray(new String[0]);
        System.out.println(Arrays.toString(namesArray));

        castObjectToBooleanArray();
    }

    private static void castObjectToBooleanArray() {
        Object obj = new Object();
        Boolean[] bools; // = (Boolean[]) obj; // this is valid though you may get Exception.
        // Reason

        Object obj1 = new Boolean[] {true, false};
        bools = (Boolean[]) obj1; // this is absolutely fine

        Object[] objArray = bools;

        bools = (Boolean[]) objArray;

        // boolean[] booleanArray = (boolean[]) obj;


    }
}
