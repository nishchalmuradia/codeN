package coreJava;

@FunctionalInterface
interface Interface2 {
    int show(int i, int j);
}

//previouslly
/*public class FunctionalIf2 {
    public static void main(String[] args) {
        Interface2 obj = new Interface2() { // anonymous inner class
            public int show(int i, int j ) {
               return `i+j;
            }
        };
        int result = obj.show(5, 4);
        System.out.println(result);
    }
}*/

// with lambda expression:


public class FunctionalIf2 {
    public static void main(String[] args) {
        Interface2 obj = (i,j) -> i+j;
        int result = obj.show(5, 4);
        System.out.println(result);
    }
}

