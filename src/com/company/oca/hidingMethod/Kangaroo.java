package com.company.oca.hidingMethod;

/**
 * Created by bikra on 11/25/2019 1:31 PM.
 */
public class Kangaroo extends Marsupial {
    public static boolean isBiped() {
        return true;
    }

    public void getKangarooDescription() {
        System.out.println("Kangaroo hops on two legs: " + isBiped());
    }

    public static void main(String[] args) {
        Kangaroo kangaroo = new Kangaroo();
        kangaroo.getMarsupialDescription();
        kangaroo.getKangarooDescription();

        // isBiped static method  can be called even the object reference is null!
        Kangaroo myKangaroo = null;
        myKangaroo.isBiped();
    }
}
