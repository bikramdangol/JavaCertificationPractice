package com.company.oca.protectedVariable.b;

import com.company.oca.protectedVariable.a.Animal;

/**
 * Created by bikra on 11/25/2019 12:21 PM.
 */
public class Dog extends Animal {
    // change this to private or protected and see what happens.
    public int age = 10;

    public int getSuperAge() {
        return super.age;
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println("Dog age calling getAge: " + dog.getAge());
        System.out.println("Dog age : " + dog.age);
        System.out.println("Dog age using super: " + dog.getSuperAge());
    }
}
