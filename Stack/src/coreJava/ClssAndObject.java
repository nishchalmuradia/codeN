package coreJava;

class Demo {
    public int add(int a, int b) {
        return a + b;
    }

}

public class ClssAndObject {

    public static void main(String[] args) {
        Demo demo = new Demo();
        int result =demo.add(5,4);
        System.out.print(result);
    }
}
