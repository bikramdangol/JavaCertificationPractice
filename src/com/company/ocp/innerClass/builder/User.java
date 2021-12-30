package com.company.ocp.innerClass.builder;

import java.util.Locale;

/**
 * Created by bikra on 4/20/2021 2:02 PM.
 */
public class User {
    public static void main(String[] args) {
        Person p = new Person.Builder().setName("Andrew").setAge(40).build();
        System.out.println(p.getName() + " " + p.getAge());

        Locale np = new Locale.Builder().build();
    }
}
