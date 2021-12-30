package com.company.ocp.innerClass;

/**
 * Created by bikra on 11/28/2019 9:47 AM.
 */
public class MemberInnerClass {
    private int x = 10;
    private int y = 500;
    interface  CanFly {
        void fly();
    }
    public class B implements  CanFly{
        private int x = 20;
        private int z = 2400;
        public void fly(){;}
        class C {
            private int x = 30;
            public void allTheX() {
                System.out.println(x);
                System.out.println(C.this.x);

                // B.this.x and Outer.B.this.x are same.
                System.out.println(B.this.x);
                System.out.println(MemberInnerClass.B.this.x);

                System.out.println(MemberInnerClass.this.x);

                // outer member variable is easily available.
                System.out.println("outer member variable is easily available");
                System.out.println(y);
                System.out.println(z);
                System.out.println(MemberInnerClass.this.y);
                System.out.println(MemberInnerClass.B.this.z);

                B bInside = new B();
                MemberInnerClass outerInside = new MemberInnerClass();
                MemberInnerClass.B bInside2 = outerInside.new B();
            }
        }
    }

    public static void main(String[] args) {
        MemberInnerClass a = new MemberInnerClass();
        MemberInnerClass.B b = a.new B();
        MemberInnerClass.B.C c = b.new C();
        c.allTheX();

        // You can do as below.
        B b1 = a.new B();
        // or
        b1 = new MemberInnerClass().new B();
        System.out.println(b1.x);
        // or
        MemberInnerClass.B b2 = new MemberInnerClass().new B();
        // But you can not do as below.
        //B b3 = new B();// Not using object.new syntax.

        // C c1 = b1.new C(); // C is not directly available for reference.
        // instead do as below.
        B.C c2 = b1.new C();
        MemberInnerClass.B.C c3 = b1.new C();
    }
}
