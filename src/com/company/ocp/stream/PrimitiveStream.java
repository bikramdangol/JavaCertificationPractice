package com.company.ocp.stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by bikra on 12/16/2019 8:52 PM.
 */
public class PrimitiveStream {
    public static void main(String[] args) {
        BooleanSupplier b1 = () -> true;
        System.out.println(b1.getAsBoolean());
        IntSupplier is = () -> 5;
        System.out.println(is.getAsInt());

        Function<Integer, Integer> integerIntegerFunction = (x) -> (int)x+x;

        IntStream myStreamOfInt = IntStream.of(1,2,3,4,5);
        int sum = myStreamOfInt.sum();
        System.out.println("Sum is: " + sum);
        IntStream myStreamOfInt1 = IntStream.of(1,2,3,4,5);
        OptionalInt maximumInt = myStreamOfInt1.max();
        System.out.println("Maximum Int value is: " + maximumInt.getAsInt());

        DoubleFunction<String> dfToString = (x -> x + " dollor");
        System.out.println(dfToString.apply(5.0));

        // IntStream can be created using of which accepts vararg. So you can pass array or comma separated parameters.
        int[] intArray = {10, 20, 30, 40};
        List<Integer> integerArrayList = Arrays.asList(1, 2, 3, 4);
        // Array has sort where as Stream has sorted method.
        // Array doesn't have filter but Stream has.
        integerArrayList.sort(Comparator.naturalOrder());

        IntStream intStreamFromArray = IntStream.of(intArray); // using array.

        IntStream intStreamFromOf = IntStream.of(1,2,3,4);// using comma separated parameters.
        DoubleStream doubleStreamFromIntStream = intStreamFromOf.mapToDouble(x -> x);// It need int to double function

        // It uses intToDoubleFunction Interface to convert from int to double.
        System.out.println();
        IntStream intStreamToSeeAverage = IntStream.of(1,2,3,4);
        System.out.println(intStreamToSeeAverage.average());

        IntStream intStream = IntStream.of(1,2,3,4);
        IntToDoubleFunction intToDoubleFunction = x -> x;
        DoubleStream doubleStreamUsingFunction = intStream.mapToDouble(intToDoubleFunction);
        System.out.println(doubleStreamUsingFunction.peek(System.out::println).sum());
       /* // Something I want to look back after sometime.
        double[] arrayDouble = doubleStreamUsingFunction.toArray();
        List<Object> doubleList = Arrays.asList(arrayDouble);
        doubleList.set(0, 100);
        System.out.println(doubleList.get(0));
        System.out.println(doubleList);*/

        // DoubleWrapper Stream to int Stream example
        System.out.println();
        Stream<Double> streamofDouble = Stream.of(5.0, 10.0, 15.0, 20.0);
        System.out.println("Average of double: " + streamofDouble.mapToDouble(x -> x).summaryStatistics().getAverage());

        Stream<Double> streamForMax = Stream.of(5.0, 10.0, 15.0, 20.0);
        Optional<Double> max= streamForMax.max(Comparator.comparing(x->x));

        Stream<Double> stream1 = Stream.of(5.0, 10.0, 15.0, 20.0);
        Optional<Double> max1= stream1.max(Comparator.comparing(Double::doubleValue));
        DoubleConsumer doubleConsumer = dval -> System.out.println(dval);
        //stream1.forEach(doubleConsumer);

        Stream<Double> stream2 = Stream.of(5.0, 10.0, 15.0, 20.0);
        Optional<Double> min= stream2.max(Comparator.naturalOrder());
        // Note stream can not be used if already used.
        Stream<Double> stream = Stream.of(5.0, 10.0, 15.0, 20.0);
        IntStream intStreamFromObjectStream = stream.peek(System.out::println).mapToInt(x -> (int) x.doubleValue());
        IntSummaryStatistics intSummaryStatistics = intStreamFromObjectStream.summaryStatistics();
        System.out.println(intSummaryStatistics);
        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());
        //System.out.println(intStreamFromObjectStream.peek(System.out::println).sum());

        // primitive summaryStatistics has getMax. Even for empty it gives max and min.
        IntStream intStreamForSummaryStastics = IntStream.empty();
        IntSummaryStatistics intSummaryStatistics1 = intStreamForSummaryStastics.summaryStatistics();
        System.out.println(intSummaryStatistics1.getMax());

        IntStream myIntStream = IntStream.empty();
        // System.out.println("find first: " + myIntStream.findFirst()); // OptionalInt.empty
        IntSummaryStatistics summaryStatistics = myIntStream.summaryStatistics();
        System.out.println("Count of empty stream: " + summaryStatistics.getCount()); // wonder why it is 0
        System.out.println("Average of empty stream: " + summaryStatistics.getAverage()); // wonder why it is 0.0
        System.out.println("Max of empty stream: " + summaryStatistics.getMax()); // wonder why it has -2147483648
        System.out.println("Min of empty stream: " + summaryStatistics.getMin());


    }
}
