package com.company.ocp.bounds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bikra on 12/15/2019 12:01 PM.
 */
public class LowerBoundedWildCard {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Mike");
        names.add("John");
        names.add("Jack");
        List<? super String> list = names;
        list.add("Justin");
        list.remove(1);
        names.forEach(x -> System.out.println(x));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Dog());


        List <? super Dog> boundedAnimals = animals;
        boundedAnimals.add(new Dog());
        // boundedAnimals.add(new Animal()); // Cannot add super type of Dog.

        // While extracting the items we need to cast it.
        Animal a1 = (Animal) boundedAnimals.get(0);
        Dog d1 = (Dog) boundedAnimals.get(1);

        System.out.println(boundedAnimals);

        Crate<? extends Animal> crate = new Crate<>(new Dog());
        //crate.setContent(new Dog());
        Animal a = crate.getContent();

    }
}

class Animal {
    public void makeSound() {
        System.out.println("Animal making sound");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Dog barking.");
    }
    public void playFetch() {
        System.out.println("Dog playing fetch");
    }
}

class Crate<T> {
    public T getContent() {
        return content;
    }

    public Crate(T content) {
        this.content = content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    private T content;

}
