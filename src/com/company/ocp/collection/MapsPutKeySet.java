package com.company.ocp.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bikra on 12/15/2019 6:35 PM.
 */
public class MapsPutKeySet {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println("Added new key value: " + map.put("koala", "bamboo"));
        System.out.println("Added new key value: " + map.put("lion", "meat"));
        System.out.println("Added new key value: " + map.put("giraffe", "leaf"));

        System.out.println();
        System.out.println("Returns old value when you put value.");
        System.out.println("Replacing old key value: " + map.put("lion", "Goat"));
        System.out.println("Add new null key: " + map.put(null, "Not known"));

        System.out.println();
        String food = map.get("lion");
        System.out.println("Food of Lion is: " + food);

        for (String key: map.keySet()) {
            System.out.println(key + ": "+ map.get(key) + ", ");
        }

        System.out.println();
        System.out.println("putIfAbsent always returns previous value, null if not already exists");
        System.out.println("PutIfAbsent when already present: " + map.putIfAbsent(null, "Null Value")); //It will not be added because there is a value for null key.
        System.out.println("PutIfAbsent when adding new: " + map.putIfAbsent("dog", null));
        System.out.println("PutIfAbsent: " + map.putIfAbsent("dog", "bone")); // It will be added because its value is null.

        for (String key: map.keySet()) {
            System.out.println(key + ": "+ map.get(key));
        }

        // Merge basics
        System.out.println();
        map.merge("giraffe", "Tree", (v1, v2) -> v1 + " and " + v2);
        System.out.println("merged value: " + map.get("giraffe"));

        // merge with non-key and mapper returning null
        map.merge("non-key1", "non-key-Value1", (v1, v2) -> null);
        System.out.println();
        System.out.println("Check if non-key is added or not with merge.");
        for (String key: map.keySet()) {
            System.out.println(key + ": "+ map.get(key) + ", ");
        }

        // merge with non-key and mapper returning non-null
        map.merge("non-key2", "non-key-Value2", (v1, v2) -> v1 + "added");
        System.out.println();
        System.out.println("Check if non-key is added or not with merge.");
        for (String key: map.keySet()) {
            System.out.println(key + ": "+ map.get(key) + ", ");
        }

        // merge with value null and mapper returning null
        map.put("keyHavingNullValue", null);
        map.merge("keyHavingNullValue", "non-null-Value1", (v1, v2) -> null);
        System.out.println();
        System.out.println("Check if keyHavingNullValue is added or not with merge.");
        for (String key: map.keySet()) {
            System.out.println(key + ": "+ map.get(key) + ", ");
        }

        // merge with value non-null and mapper returning null
        map.put("keyHavingValue", "initialValue");
        map.merge("keyHavingValue", "non-null-Value2", (v1, v2) -> null);
        System.out.println();
        System.out.println("Check if value for key keyHavingValue is added as null with merge.");
        for (String key: map.keySet()) {
            System.out.println(key + ": "+ map.get(key) + ", ");
        }
    }
}
