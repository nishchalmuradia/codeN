package coreJava;

class P {
    public P() {
        super();// it is still there  if you dont meentioned it. it is the first statement
        // that execute in the constructor.
        System.out.println("in P");
    }

    public P(int n) {
        super();// it is still there  if you dont meentioned it. it is the first statement
        // that execute in the constructor.
        System.out.println("in P int");
    }
}

class Q extends P {
    public Q() {
        super();
        System.out.println("in Q");
    }

    public Q(int n) {
        this();
        System.out.println("in Q int");
    }

}

public class ThisMethod {
    public static void main(String[] args) {
        Q b = new Q(5);
    }

}
