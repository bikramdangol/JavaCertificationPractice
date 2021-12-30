package com.company.ocp.innerClass.staticInterface;

/**
 * Created by bikra on 4/20/2021 1:38 PM.
 */
public class ClassHavingInnerInterface {
    // static keyword is redundant for inner public interface.
    public static interface InnerInterface {
        void method();
    }

    // interface can be private! Inner Interface are implicitly static.
    private static interface InnerPrivateInterface {
        void print();
    }

    private class InnerClass implements InnerPrivateInterface {

        @Override
        public void print() {

        }
    }
}
