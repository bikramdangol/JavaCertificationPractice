package com.company.ocp.exam.array;

/**
 * Created by bikra on 4/24/2021 11:34 PM.
 */
public class ArrayPrint {
    public static void main(String[] args) {
        char[][] nums = {{'a','b'}, {'c','d'}, {'e','f'}};
        for (char[] a: nums) {
            for(char b: a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
