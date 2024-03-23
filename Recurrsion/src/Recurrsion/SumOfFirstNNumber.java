package Recurrsion;

public class SumOfFirstNNumber {


    public static void main(String[] args) {
        int n=3;
        System.out.println(sumFun(n));
    }

    private static int sumFun(int n) {
        if(n==0){
            return 0;
        }else{
            return n+ sumFun(n-1);
        }
    }
}
