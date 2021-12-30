package com.company.ocp.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bikra on 12/16/2019 2:14 PM.
 */
public class BasicStream {
    public static void main(String[] args) throws Exception{

        Predicate<String> predicate = s -> s.equals("g");
        Stream.of("a", "b", "g", "x").filter(predicate).count();
        //Stream.of(new Object(), new Object()).filter(predicate).count();
        Stream<String> emptyStream = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);

        String names1 = "Mike,Vivian,Kashif,Kevin";
        String names2 = "Mike,Vivian,Kashif,Kevin";
        String[] namesArray = names1.split(",");
        Stream<String> nameStream = Stream.of(names1, names2);

        // It is not stream of Array. It will be Stream of the contents of Array.
        Stream<String> nameStreamFromArray = Stream.of(namesArray);
        nameStreamFromArray.sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);


        nameStream.flatMap(line -> Stream.of(line.split(",")))
                .map(s -> s.toUpperCase())
                .forEach(System.out::print);
        /*Files.lines(Paths.get("log.txt"))
        .flatMap(p -> Stream.of(p.split(" ")))
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);*/


        // Stream from Array
        Stream<Integer> fromArray = Stream.of(1,2,3,4);
        Integer[] integerArray = {10, 20, 30, 40, 50};
        Stream<Integer> fromArray2 = Stream.of(integerArray);
        fromArray.peek(System.out::println).count();
        fromArray2.forEach(System.out::println);

        System.out.println();
        // Stream from List
        List<String> list = Arrays.asList("Mike", "Vivian", "Kevin", "Kashif");
        Stream<String> fromList = list.stream();
        fromList = list.parallelStream();
        fromList.forEach(System.out::println);

        // Generator
        System.out.println();
        Stream<Double> randoms = Stream.generate(Math::random);
        randoms.limit(3).forEach(System.out::println);

        System.out.println();
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n+2);
        oddNumbers.limit(5).forEach(System.out::println);

        //Flat Map
        // Question 1
        Set<String> set = new HashSet<>();
        set.add("tire-");

        List<String> linkedList = new LinkedList<>();
        Deque<String> stringDeque = new ArrayDeque<>();
        stringDeque.push("wheel-");

        Stream.of(set, linkedList, stringDeque)
                .flatMap(x -> x.stream())
                .forEach(System.out::print);

        // Question 2
        System.out.println();
        List<String> stringList = Arrays.asList("A", "B", "C");
        Stream.of(stringList)
                .flatMap(x->x.stream())
                .map(x->x)
                .forEach(System.out::print);

        System.out.println();
        // It is a stream of list not the contents.
        Stream.of(stringList)
               // .map(x->x)
                .forEach(System.out::print);

        Stream.empty().map(x -> {
            System.out.println("Is there anything?" + x + "checked") ;
            return x; })
                .forEach(x -> {
                        System.out.println("Tried to print data: " + x + " data") ;
         });

        Stream.of("Hello", "World").map(x -> {
            System.out.println("Is there anything? " + x + " checked") ;
            return x; })
                .forEach(x -> {
                    System.out.println("Tried to print data: " + x + " data") ;
                });

    }
}
