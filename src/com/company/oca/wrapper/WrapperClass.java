package com.company.oca.wrapper;

/**
 * Created by bikra on 11/25/2019 8:27 PM.
 */
public class WrapperClass {
    /***** /* //sfdas * / sfdafds*/
    public static void main(String[] args) {

        byte primitiveByte = 127;
        // byte primitiveByteNotAllowed = 128;
        short primitiveShort = 12345;
        int primitiveInt = 1234557890;
        long primitiveLong1 = 1234567890;
        long primitiveLong2 = 123456789012L;

        // float primitiveFloatNotAllowed = 123.;
        float primitiveFloat = 123;
        float primitiveFloat2 = 123.0F;
        double primitiveDouble1 = 1234;
        double primitiveDouble2 = 1234.0f;

        long l15 = null == null ? (int) (10.0 * 10.0) : 0;


        // Byte numByteNotAllowed = new Byte(1);
        // Short numShortNotAllowed = new Short(1);
        Byte numByteDeprecated = new Byte((byte) 1);
        Byte numByte = Byte.valueOf((byte)1);
        Short numShort = new Short((short) 1);

        Integer numIntegerDeprecated = new Integer(1);
        Integer numInteger = Integer.valueOf(1);
        long l1 = numInteger;
        Long numLong = new Long(1);
        Float numFloat = new Float(1);
        Double numDouble = new Double(1);

        numDouble.intValue();
        numDouble.longValue();
        numDouble.toString();
        // Not allowed.
        //Long l101 = new Integer(101);

        //parseXXX gives primitive value.
        int intValue = Integer.parseInt("5");
        long longValue = Long.parseLong("123");

        // valueOf gives Wrapper Object.
        Integer integerWrapper = Integer.valueOf("100");
        Long longWrapper = Long.valueOf("200");

        // But you can do this
        Integer x = Integer.parseInt("20"); // Autobox occurs.
        int y = Integer.valueOf("30"); // Auto unbox occurs.

        int fromBinary = 0b101;
        int fromOctal = 017;
        int fromHex = 0xAFF;
        int fromChar = '\u0FED';
        char charUnicode = '\u0918';

        Number ternaryValue = 5>2 ? new Integer(4) : new Double(5.0);
        System.out.println(ternaryValue);

        Short s1 = 400;
        Integer i1 = 500;
        Integer str1 = (s1 + i1);
    }
}
