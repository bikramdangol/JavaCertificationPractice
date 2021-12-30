package com.company.ocp.exam.overload;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bikra on 4/24/2021 11:29 PM.
 */
public class OverloadMethod {
    static void doStuff(Object[] objects) {
        System.out.println("In Objects Array");
    }
    static void doStuff(Object object) {
        System.out.println("In Object");
    }

    static void doStuff(long[] longs) {
        System.out.println("In long array");
    }

    /*static void doStuff(int[] longs) {
        System.out.println("In int array");
    }*/

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nums = new int[0];
        doStuff(nums);
        doMore(5);

        Integer[] integerArray = { 1, 2, 3};
        Object[] objects = integerArray;

        String[] nameArray =  {"Hello", "World"};
        List<String> nameList = Arrays.asList(nameArray);

        Object[] myObjArr = { "adasf", "sdfa"};

        //String[] stringArray = (String[]) nameList.toArray();
        String[] stringArray = nameList.toArray(new String[0]);
        System.out.println("done");

        int x = 5, y = 10, z = 15;
        double a = x/(double)y, b = z/x;
        System.out.println(a + " " + b);

        float f1 = 0.1f;
        double d1 = f1;
        double d2 = 1 + f1;
        float f2 = (float) d1;
        System.out.println(f1 + " " +(long)(d1*100)/100.0 + " " + (long)(d2*100)/100.0 + " " + f2);
    }

    /*static void doMore(long x) {
        System.out.println("In long");
    }*/

    static void doMore(Long x) {
        System.out.println("In Long wrapper");
    }

    static void doMore(Object x) {
        System.out.println("In Object");
    }
}
