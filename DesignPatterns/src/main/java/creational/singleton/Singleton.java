package creational.singleton;

public class Singleton {


    public static void main(String[] args) {


        // here we can create only one object of a class. (instacne of class baciallly)
        // means if u try to ctreate another object of that class iut will give you the same onket

        Abc obj1 = Abc.getInstance();
        Abc obj2 = Abc.getInstance();

    }

}

class Abc {
    // 3 things to implemene this
    // 1. create static obj
    // 2. keep your constructor private so no once can use
    // 3. create getinstance method and return static object

    private static Abc obj = new Abc();

    private Abc() {
        System.out.println("Instance created");
    }

    public static Abc getInstance() {
        return obj;
    }

    // by default it is EAGAR implementaoin of object creation
    // object is creating when the class is loading jno matter we ar using this object or not.
    // this is bad
    // if u want to craete this at the run time then we can use the lAZY


}