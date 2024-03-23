package coreJava;

interface InterfacesExample {
int age=44;
String str = "str";
    void show();
    void config();
}

class B1 implements InterfacesExample{


    public void show() {
        System.out.println("inside show");
    }


    public void config() {
        System.out.println("Inside config");
    }
}
class A1{
    public static void main(String[] args) {
        InterfacesExample obj = new B1();
        obj.config();
        System.out.println(obj.age);

    }
}
