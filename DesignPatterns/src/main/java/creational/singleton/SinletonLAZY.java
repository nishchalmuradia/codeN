package creational.singleton;

public class SinletonLAZY {

    public static void main(String[] args) {

        // her we will create the object  at the time of run

        Def obj1 = Def.getInstance();
        Def obj2 = Def.getInstance();

    }

}

class Def {
    private static Def obj;// dont initilise the object so it will not create at the load time

    private Def() {
        System.out.println("Instance created");
    }

    public static Def getInstance() {

        if(obj==null){
            obj = new Def(); // need to check here that there is already object created or not(instance)
        }
        return obj;
    }

    // any issue here?=> yes
    // what if we are using thread here
    // thread will run in parallel and both find out that the obj is null and create 2 instance and return it.


}