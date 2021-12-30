package com.company.oca.protectedVariable.far;

import com.company.oca.protectedVariable.a.Animal;
import com.company.oca.protectedVariable.b.Dog;

/**
 * Created by bikra on 11/25/2019 2:42 PM.
 */
public class DogRunner {
    public static void main(String[] args) {
        Animal animal = new Dog();
        Dog dog = new Dog();
        System.out.println("Dog age with animal reference: " + animal.age);
        System.out.println("Dog age with dog reference: " + dog.age);
    }
}
