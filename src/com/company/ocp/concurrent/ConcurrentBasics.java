package com.company.ocp.concurrent;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.DoubleStream;

/**
 * Created by bikra on 12/22/2019 1:13 PM.
 */
public class ConcurrentBasics {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("Mike");
        stringList.add("Vivian");
        // you get ConcurrentModificationException if list is modified in iterator.
        /*for(String name: stringList) {
            stringList.add("Binit");
        }*/

        Map<String, Object> conMap = new ConcurrentHashMap<>();
        conMap.put("RAV4", 2);
        conMap.put("ROGUE", 5);
        // No exception when modified inside iterator.
        for(String name: conMap.keySet()) {
            conMap.put("CIVIC", 3);
        }
        System.out.println(conMap);

        // Question 1
       question1();

        // Question 2
        System.out.println("\nQuestion2");
        question2();

        // Question 3
        System.out.println("\nQuestion3");
        question3();

        // Question 4
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        DoubleStream.of(3.14159, 2.71828)
                .forEach(c -> service.submit(() -> System.out.println(10*c)));
        // Note scheduleExecutorService has submit and execute method in addition to schedule, scheduleAtFixedRate,
        // scheduleWithFixedDelay
        service.execute(() -> System.out.println("printed"));
        if(service != null) service.shutdown();
    }

    private static void question3() {
        System.out.println(Arrays.asList("duck", "chicken", "flamingo", "pelican")
        .parallelStream().parallel()
                //check the signature of reduce. First(c1) should match with identity 0(number) and the second is the item string.
        .reduce(0,
                (c1, c2) -> c1 + c2.length(),
                (s1, s2) -> s1 + s2));
    }

    private static void question2() {
        Integer i1 = Arrays.asList(1, 2, 3, 4, 5, 5).stream().findAny().get();
        Integer i2 = Arrays.asList(6, 7, 8, 9, 10)
                .parallelStream()
                //.stream()
                .sorted()
                .peek(System.out::println)
                .findAny()
                .get();
        System.out.println(i1 + " " + i2);
    }

    private static void question1() {
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        //l1.add(4); // UnsupportedOperationException

        Integer[] ia = {1, 2, 3};
        List<Integer> l2 = Arrays.asList(ia);
        //l2.add(5); // UnsupportedOperationException

        List<Integer> l3 = new CopyOnWriteArrayList<>(l1);
        Set<Integer> s3 = new ConcurrentSkipListSet<>();
        s3.addAll(l1);

        // No concurrent modification exception as it uses CopyOnWriteArrayList.
        // It adds 3 items "4" making twice the size.
        for (Integer item: l3) {
            l3.add(4);
        }

        // It is a set hence the size increases by only one.
        for (Integer item: s3) {
            s3.add(5);
        }
        System.out.println(l1.size() + " " + l3.size() + " " + s3.size());
    }
}
