package com.company.ocp.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by bikra on 4/24/2021 1:29 PM.
 */
public class ArrayToStream {
    public static void main(String[] args) {
        int data[] = { 1, 2, 3, 4, 5 };

        //iterative way to compute sum and average of an array
        int sum = 0;

        for(int i = 0; i< data.length; i++) {
            sum+= data[i];
        }

        System.out.println("Sum : " + sum);
        System.out.println("Average : " + sum/data.length);

        //declarative way to compute sum and average of an array

        IntStream s = Arrays.stream(data);
        IntSummaryStatistics ss = s.summaryStatistics();
        System.out.println("Sum: " + ss.getSum());
        System.out.println("Average: " + ss.getAverage());


        sum = Arrays.stream(data).sum();

        System.out.println("Sum : " + sum);
        System.out.println("Average : " + sum/data.length);
    }
}
