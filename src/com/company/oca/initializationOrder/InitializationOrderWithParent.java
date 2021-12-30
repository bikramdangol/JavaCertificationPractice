package com.company.oca.initializationOrder;

/**
 * Created by bikra on 4/19/2021 9:26 PM.
 */
abstract  class Car {
    static {
        System.out.println(Car.name);
        System.out.print(1);
    }

    static String name = "Toyota";

    public Car(String name) {
        super();
        System.out.print("2");
    }

    {
        System.out.print("3");
    }
}
public class InitializationOrderWithParent extends Car {

    static {
        System.out.print("4");
    }

    {
        System.out.print("5");
    }
    public InitializationOrderWithParent() {
        super("blue");
        System.out.print("6");
    }

    public String getId() {
        return "id";
    }

    public static void main(String[] args) {
        System.out.print("7");
        Object obj = (Object) new InitializationOrderWithParent().getId();
        // Outputs: 147 32 56  please ignore space.
    }
}
