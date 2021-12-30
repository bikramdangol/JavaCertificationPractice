package com.company.oca.hidingMethod;

/**
 * Created by bikra on 11/25/2019 1:29 PM.
 */
public class Marsupial {
    // if marked as final, it cannot be hidden.
    public static boolean isBiped() {
        return false;
    }
    public void getMarsupialDescription() {
        System.out.println("Marsupial walks on two legs: " + isBiped());
    }
}
