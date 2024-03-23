package coreJava;

@FunctionalInterface
interface Interface1 {
    void show(int i);
}

//previouslly
/*public class FunctionalIf {
    public static void main(String[] args) {
        Interface1 obj = new Interface1() { // anonymous inner class
            public void show(int i) {
                System.out.println("in show " + i);
            }
        };
        obj.show(5);
    }
}*/

// with lambda expression:

public class FunctionalIf {
    public static void main(String[] args) {
        Interface1 obj = (i) -> System.out.println("in show " + i);
        obj.show(5);
    }
}
