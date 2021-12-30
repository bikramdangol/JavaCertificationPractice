package com.company.ocp.innerClass.builder;

/**
 * Created by bikra on 4/20/2021 1:58 PM.
 */
public class Person {
    private String name;
    private int age;
    public static class Builder {
        private Person person = new Person();
        public Builder setName(String name) {
            person.name = name;
            return this;
        }

        public Builder setAge(int age) {
            person.age = age;
            return this;
        }

        public Person build() {
            return person;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
