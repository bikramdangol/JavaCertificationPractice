package com.company.oca.overload;

/**
 * Created by bikra on 4/23/2021 7:59 PM.
 */
// package private(default) interface.
interface CanSwim {
    boolean swim();
}

class Animal {
    public void makeSound() {
        System.out.println("Animal making sound.");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Dog making sound. Whoof");
    }
}
public class OverloadCheck {
    public static void process (Animal a) {
        a.makeSound();
    }

    public static void process (Dog d) {
        d.makeSound();
    }
    public static void main(String[] args) {
        System.out.println("Animal passed:");
        Animal animal = new Animal();
        process(animal);
        System.out.println("Animal Ref Dog object passed: ");
        Animal a = new Dog();
        process(a);

    }
}
