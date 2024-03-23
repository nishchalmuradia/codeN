package External;


class P1 {
    public P1() {
        this(5);
        System.out.println("In P1");
    }

    public P1(int n) {
        System.out.println("In P1 HAHAHHH");
    }
}

class P2 extends P1 {
    public P2() {
        super();
        System.out.println("In P2");
    }
}

public class Testing {
    public static void main(String[] args) {
        P2 p = new P2();


    }
}
