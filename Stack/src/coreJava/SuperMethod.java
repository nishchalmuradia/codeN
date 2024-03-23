package coreJava;

class A {
    public A() {
        super();// it is still there  if you dont meentioned it. it is the first statement
        // that execute in the constructor.
        System.out.println("in A");
    }

    public A(int n) {
        super();// it is still there  if you dont meentioned it. it is the first statement
        // that execute in the constructor.
        System.out.println("in A int");
    }
}

class B extends P {
    public B() {
        super(5);
        System.out.println("in B");
    }

    public B(int n) {
        super();
        System.out.println("in B int");
    }

}

public class SuperMethod {
    public static void main(String[] args) {
        Q b = new Q();
    }

}
