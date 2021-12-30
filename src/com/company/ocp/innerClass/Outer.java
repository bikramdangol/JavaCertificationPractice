package com.company.ocp.innerClass;
public class Outer {
    private int x = 24;
    public int getX() {
        String message = "x is ";
        MemberInnerClass memberInnerClass = new MemberInnerClass();
        MemberInnerClass.B innerBClass = memberInnerClass.new B();
        class Inner implements MemberInnerClass.CanFly {
            private int x1 = x + 1;
            private int x2 = Outer.this.x;
            public void printX() {
                System.out.println(message + x);
                System.out.println(message + x1);
            }

            @Override
            public void fly() {

            }
        }
        //message = "something else";
        x = 10;
        Inner in = new Inner();
        in.printX();
        return x;
    }

    // Not possible to extend MemberInnerClass.B.C but MemberInnerClass.Interface.
    class InnerExtendingAnotherInner extends MemberInnerClass implements MemberInnerClass.CanFly{
        private int x = 5;

        @Override
        public void fly() {

        }
    }

    public static void main(String[] args) {
        new Outer().getX();
        MemberInnerClass memberInnerClass = new MemberInnerClass();
        MemberInnerClass.B innerBClass = memberInnerClass.new B();
        innerBClass.fly();


    }
}
