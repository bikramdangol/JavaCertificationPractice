package com.company.oca.staticInitialization;

/**
 * Created by bikra on 11/25/2019 7:12 PM.
 */
public class YetMoreInitializationOrder {
    static { add(2); }
    static void add(int num ) {
        System.out.println("{" + num + " " + price + "} ");
    }
    static int price = 5;
    YetMoreInitializationOrder() { add(200);}
    static { add(4);}
    { add(26); }
    static { new YetMoreInitializationOrder(); }
    { add (28);}

    public static void main(String[] args) {
       /* prints
        {2 0}
        {4 5}
        {26 5}
        {28 5}
        {200 5}
        */
    }
}
