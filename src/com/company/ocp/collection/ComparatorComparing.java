package com.company.ocp.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by bikra on 12/15/2019 8:42 PM.
 */
public class ComparatorComparing {

    public static void main(String[] args) {
        List<Squirrel> squirrels = Arrays.asList(
                new Squirrel(10, "B"),
                new Squirrel(50, "A"),
                new Squirrel(5, "C"),
                new Squirrel(10, "A"),
                new Squirrel(40, "A")
                );
        Collections.sort(squirrels, new ChainingComparator<>());
        System.out.println(squirrels);

        // ChainingComparator works for both super and child class.

        List<SquirrelChild> squirrelChildren = Arrays.asList(
                new SquirrelChild(10, "B"),
                new SquirrelChild(50, "A"),
                new SquirrelChild(5, "C"),
                new SquirrelChild(10, "A"),
                new SquirrelChild(40, "A")
        );
        Collections.sort(squirrelChildren, new ChainingComparator<>().reversed());
        System.out.println(squirrelChildren);

        // Question related to reverseOrder
        Stream<String> s = Stream.of("over the river", "through the woods", "to grandmother's house we go");
        s.filter(n -> n.startsWith("t"))
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .ifPresent(System.out::println);
    }
}
class Squirrel {
    private int weight;
    private String species;

    public Squirrel(int weight, String species) {
        this.weight = weight;
        this.species = species;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Squirrel{" +
                "weight=" + weight +
                ", species='" + species + '\'' +
                '}';
    }
}

class SquirrelChild extends Squirrel {
    SquirrelChild(int weight, String species){
        super(weight, species);
    }

    @Override
    public String toString() {
        return "SquirrelChild{" +
                "weight=" + getWeight() +
                ", species='" + getSpecies() + '\'' +
                '}';
    }
}

class ChainingComparator<T extends Squirrel> implements Comparator<T> {
    public int compare(T s1, T s2) {
        Comparator<T> c = Comparator.comparing(T::getSpecies);
        c = c.thenComparingInt(s -> s.getWeight());
        return c.compare(s1, s2);
    }
}
