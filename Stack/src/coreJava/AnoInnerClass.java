package coreJava;

public class AnoInnerClass {

    public void show(){
        System.out.println("Inside show");
    }
    public static void main(String[] args) {
        AnoInnerClass obj = new AnoInnerClass()
        {
            public void show(){
            System.out.println("Inside new Show");
        }
        };
        obj.show();
    }
}
