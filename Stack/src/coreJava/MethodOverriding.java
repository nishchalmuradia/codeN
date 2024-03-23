package coreJava;

 class First{
    public void show(){
        System.out.println("inside show First");// this will not be called beacuse B class objct
        // nwill get prefrence and it will overriding the First class show method.
    }
     public void config(){
         System.out.println("inside config First");
     }
}
class Second extends First{
    public void show(){
        System.out.println("inside show Second");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Second s = new Second();
        s.show();
        s.config();

    }
}
