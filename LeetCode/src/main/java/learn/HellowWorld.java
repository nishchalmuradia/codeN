package learn;

public class HellowWorld {


    public static void printNumber() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        int [] arr = {10,2,3,4,5};
        //printNumber();

        //printByArray(arr);

        //varible
        int i;
        String a = "abc";
        char ac = 'c';

        // if else
        ifElseFunction();



    }

    private static void printByArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void ifElseFunction(){
        int age = 400;

        if(age>18){
            System.out.println("VOTE");
        }else{
            System.out.println("N)");
        }

       String result =  age>18? "VOTE":  "NO";
        System.out.println(result);
    }
}
