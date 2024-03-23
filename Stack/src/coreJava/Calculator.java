package coreJava;

class Calc{
    public int add(int a, int b){
        return  a+b;
    }
    public int sub(int a, int b){
        return  a-b;
    }
}

class AdvanceCalc extends Calc{
    public int mul(int a, int b){
        return  a*b;
    }
    public int div(int a, int b){
        return  a/b;
    }
}

public class Calculator {
    public static void main(String[] args) {
        AdvanceCalc a = new AdvanceCalc();
        int r1 = a.mul(6,3);
        int r2 = a.div(6,3);
        int r3 = a.add(6,3);
        int r4 = a.sub( 6,3);

    }
}
