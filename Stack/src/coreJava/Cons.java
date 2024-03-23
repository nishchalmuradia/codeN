package coreJava;
class Human {
    int age;
    String name;

    public Human(){
        System.out.println("Inside cons.");  //default cons
    }

    public Human(int a, String  n){ //parameter. cons.
       age = a;
       name= n;
    }

}

public class Cons {
    public static void main(String[] args) {
        Human hu = new Human();
        System.out.println(hu.age +": " + hu.name);

        Human hu1 = new Human(20, "Nish");
        System.out.println(hu1.age +": " + hu1.name);
    }


}
