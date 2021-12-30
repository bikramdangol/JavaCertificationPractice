package com.company.oca.staticInitialization;

/**
 * Created by bikra on 11/25/2019 7:25 PM.
 */
public class InstanceInitializationOrder {

    {
        // Below is local variable for this block. no public, private!
        String initString = "initString";
        // Below line access name which is declared but not yet initialized, hence prints null.
        System.out.println("setting field. current name is: " + this.name);
        // Note there is 2nd initializer block as well.
    }

    private String name = "Fluffy";

    public InstanceInitializationOrder() {
        // Constructor is called after initializer blocks.
        name = "Tiny";
        System.out.println("setting constructor.");
    }

   /* {
        System.out.println("Try to access initString: " + initString);
    }*/

    public static void main(String[] args) {
        InstanceInitializationOrder instanceInitializationOrder = new InstanceInitializationOrder();
        System.out.println(instanceInitializationOrder.name);
    }

    {
        String initString = "initString";
        // Below line access name which is declared and initialized just above, hence prints Fluffy.
        System.out.println("2nd initializer. current name is: " + this.name);
    }
}
