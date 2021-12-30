package com.company.ocp.collection;

import java.util.*;

/**
 * Created by bikra on 4/19/2021 11:51 AM.
 */
public class ListSet {
    public static void main(String[] args) {
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Mike");
        uniqueNames.add("Juli");
        uniqueNames.add("Mike");
        uniqueNames.add(null);
        System.out.println("Size: " + uniqueNames.size());
        uniqueNames.remove("Mike");
        System.out.println("After remove Size: " + uniqueNames.size());

        List<String> names = new ArrayList<>();
        names.add("Mike");
        names.add("Juli");
        names.add("Mike");
        names.add(null);
        names.add(2, "Harry");
        System.out.println("Size: " + names.size());
        names.remove("Mike");
        System.out.println(names);
        System.out.println("After remove Size: " + names.size());

        Map<String, String> nameMap = new HashMap<>();
        System.out.println("add initial name: " + nameMap.put("name", "Mike"));
        nameMap.put("city", "wilmington");
        System.out.println(nameMap.put("name", "Juli"));
        System.out.println("Merged" + nameMap.merge("name", "Binit", (v1, v2) -> v1 + ", " + v2));
        System.out.println("Merged unavailable: " + nameMap.merge("boat", "Ship", (v1, v2) -> v1 + ", " + v2));
        System.out.println(nameMap.put("house", null));
        System.out.println(nameMap.put("house", "new house"));
        System.out.println(nameMap.get("house"));
        System.out.println(nameMap);

    }
}
