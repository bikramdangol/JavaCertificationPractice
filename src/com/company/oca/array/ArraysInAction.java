package com.company.oca.array;

import com.company.oca.hidingMethod.Kangaroo;
import com.company.oca.hidingMethod.Marsupial;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bikra on 11/26/2019 8:50 PM.
 */
public class ArraysInAction {
    public static void main(String[] args) {

        Marsupial[] marsupials = new Marsupial[5];
        marsupials[0] = new Marsupial();

        Kangaroo[] kangaroos = new Kangaroo[5];
        kangaroos[1] = new Kangaroo();

        Object[] objects = new Object[5];

        // super class type array can point to sub class type array.
        // In other word, sub class type array can be assigned to super type array (objects = marsupials);.
        marsupials = kangaroos;
        // After the array is assigned to sub class type, it won't let you add the super type object.
        //marsupials[2] = new Marsupial();// throws ArrayStoreException.
        marsupials[3] = new Kangaroo();

        //marsupials = objects; wrong
       // objects = marsupials; //right
        //objects[0] = new Object(); //?

        int[][] array = new int[2][5];
        array[0] = new int[] {1, 2, 3, 4, 5, 6};
        array[1] = new int[] {2, 3, 4};

        // This type of initialization is not allowed.
        //array[1] = {2, 3, 4};

        //This type of initialization is allowed when declared.
        int[] intArray = {4,7,8};
        int[] intArray2 = new int[]{4,7,8};
        // Do not include size in RHS if you are initializing.
        //int[] intArray3 = new int[3]{4,7,8}; // does not compile.

        int[][][] array3 = new int[2][][];
        array3[0] = new int[][]{{1, 2, 5}, {1, 2, 3}, {1, 2, 3, 4, 5},{1, 2, 3, 4, 5},{1, 2, 3, 4, 5}};
        array3[1] = new int[6][];
        array3[1][0] = new int[]{5,6};
        array3[1][1] = new int[]{5,6, 7};
        array3[1][2] = new int[]{5,6,9};
        array3[1][3] = new int[]{5,6,3,5,8};
        array3[1][4] = new int[]{5,6,3,5,8,7};
        array3[1][5] = new int[]{5,6,3,5,8,8,9,0};

        System.out.println(array3[1][0][0]);
        System.out.println(array3[1][0][1]);
        //array3[1][0][1] =array3[1][0][2] = 8;

        array3[1][0] = array3[1][5];
        array3[1][0][2] = 18;

        for (int i=0; i < array3.length; i++){
            for(int j=0; j < array3[i].length; j++){
                for(int k = 0; k < array3[i][j].length; k++){
                    System.out.print(array3[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println(array);
        System.out.println(Arrays.toString(array3));

        arraysAsList();
    }

    private static void arraysAsList() {
        List<String> names = Arrays.asList("A", "B");
        // names.add("C"); It won't let you add/remove items as it is backed by Array.
        // names.remove(0);
        System.out.println(names);
    }
}
