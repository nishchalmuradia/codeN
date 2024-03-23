package coreJava;

public class InnerClassExample {

    int a;

    public void show(){
        System.out.println("in show");
    }

    class InnerClass{
        public void config(){
            System.out.println("in config");
        }
    }
    public static void main(String[] args) {
        InnerClassExample obj = new InnerClassExample();
        obj.show();

        InnerClassExample.InnerClass obj1 = obj.new InnerClass();
        // in case of static inner class: -->  new InnerClassExample.InnerClass();
        obj1.config();

    }
}
