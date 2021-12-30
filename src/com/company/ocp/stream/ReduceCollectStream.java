package com.company.ocp.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bikra on 12/16/2019 3:13 PM.
 */
public class ReduceCollectStream {
    public static void main(String[] args) {
        // Reduce
        // It gives the same data type.
        Stream<Integer> numStream = Stream.of(3, 5, 6);
        BinaryOperator<Integer> op = (a, b) -> a * b;
        System.out.println(numStream.reduce(1, op));

        // collect
        // It gives the data in another form.
        // It is mutable reduction and efficient than reduce.
        System.out.println();
        Stream<String> stringStream = Stream.of("W", "o", "l", "f");
        BinaryOperator<String> ops = String::concat;
        StringBuilder word = stringStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(word);

        // Another way of collect
        System.out.println();
        Stream<String> stringStreamForTreeSet = Stream.of("w", "o", "l", "f");
        TreeSet<String> treeSet = stringStreamForTreeSet.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(treeSet);

        // Another way of collect using toCollection
        System.out.println();
        Stream<String> stringStreamForCollect = Stream.of("w", "o", "l", "f");
        TreeSet<String> treeSet2 = stringStreamForCollect.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet2);

        // Another way of collect using toSet
        System.out.println();
        Stream<String> stringStreamForSet = Stream.of("w", "o", "l", "f");
        //TreeSet<String> set = stringStreamForSet.collect(Collectors.toTreeSet());
        Set<String> set = stringStreamForSet.collect(Collectors.toSet());
        System.out.println(set);

        // Another way of collect using toMap
        System.out.println();
        Stream<String> stringStreamForMap = Stream.of("You", "Are", "Good", "Boys");
        // Below line throws IllegalStateException because of Duplicate key. So you need the third parameter as resolver.
        //Map<Integer, String> map = stringStreamForMap.collect(Collectors.toMap(String::length, String::toString));
        Map<Integer, String> map = stringStreamForMap.collect(Collectors.toMap(String::length, String::toString, String::concat));
        System.out.println(map);


        System.out.println(Arrays.asList("duck","chicken","flamingo","pelican")
                .parallelStream().parallel() // q1
                .reduce(0,
                        (c1, c2) -> c1 + c2.length(), // q2
                        (s1, s2) -> s1 + s2)); // q3
    }
}
