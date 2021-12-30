package com.company.ocp.collection;

/**
 * Wrapper class initialization.
 * Created by bikra on 12/15/2019 10:32 AM.
 */
public class WrapperClass {
    public static void main(String[] args) {
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("FaLSe");

        // Casting to same or lower size is required.
        Byte by1 = new Byte((byte) 1);
        Short s1 = new Short((byte) 2);

        // Wrapper from String. It calls parseXxx().
        Byte byteFromString = new Byte("1");
        Integer iFromString = new Integer("1");

        Integer i1 = new Integer(5);
        Long l1 = new Long(10);

        // Specifying float at the end is not required.
        Float f1 = new Float(1L);
        Float f2 = new Float(2.0f);
        Float f3 = new Float(3.0);

        // Any value is fine to create Double wrapper.
        Double d1 = new Double(4);
        Double d2 = new Double(5.0f);
        Double d3 = new Double(6.0d);
        Double d4 = new Double(7.0);
        Double d5 = new Double("8");
        Double dFromFloat = Double.valueOf(7.8f);
        Double dFromString = Double.valueOf("7.8f");

        Character c1 = new Character('C');

        Integer i10 = new Integer(10);
        Double d20 = new Double(20);
        Double dsum = i10 + d20;
        System.out.println(dsum);
        Long l10 = new Long(10);
        l10.intValue();

        Number numberLong = l10;
        // You can not cast Long to int.
        // System.out.println((int)numberLong); // throws ClassCastException
        System.out.println((long)numberLong);
        System.out.println("Int Value is fine: " + (numberLong.intValue()));

        Number numberInteger = i10;
        // System.out.println((long)numberInteger); // throws ClassCastException
        System.out.println((int)numberInteger);
    }
}
