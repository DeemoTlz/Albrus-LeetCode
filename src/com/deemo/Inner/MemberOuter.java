package com.deemo.Inner;

public class MemberOuter {

    private int a = 1;
    public int b = 2;
    public int c = 2;
    private static int aa = 3;

    public class Inner {
        private int a = 3;
        public int b = 4;

        public void print() {
            System.out.println("a = " + a);
            System.out.println("MemberOuter.this.a = " + MemberOuter.this.a);
            System.out.println("b = " + b);
            System.out.println("MemberOuter.this.b = " + MemberOuter.this.b);
            System.out.println("MemberOuter c = " + c);
        }
    }

    public void print() {
        System.out.println("a = " + a);
        System.out.println("new Inner().a = " + new Inner().a);
        System.out.println("b = " + b);
        System.out.println("new Inner().b = " + new Inner().b);
    }

    public void constrator() {
        Inner inner = new Inner();
    }

    public static void constrators() {
        Inner inner = new MemberOuter().new Inner();
    }
}

class InnerTest {
    public static void main(String[] args) {
        MemberOuter memberOuter = new MemberOuter();
        memberOuter.print();
        System.out.println("=========================");
        memberOuter.new Inner().print();
    }
}
