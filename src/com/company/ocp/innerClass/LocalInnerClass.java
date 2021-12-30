package com.company.ocp.innerClass;

/**
 * Created by bikra on 11/28/2019 10:09 AM.
 */
public class LocalInnerClass {
    private int length = 5;
    public void calculate() {
        final int width = 20; // Local variable must be final or effectively final so that inner local class can use it.
        class Inner {
            public void multiply() {
                System.out.println("Using OuterClass.this.length: The area is: " + (LocalInnerClass.this.length * width));
                System.out.println("Accessing using only length: The area is: " + (length * width));
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        LocalInnerClass outer = new LocalInnerClass();
        outer.calculate();
    }

}
