package creational.singleton;

public class SynchronizedSingleton {

    public static void main(String[] args) {

// lets create threads
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Ghi obj1 = Ghi.getInstance();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Ghi obj1 = Ghi.getInstance();
            }
        });
        t1.start();
        t2.start();



    }

}

class Ghi {
    private static Ghi obj;// dont initilise the object so it will not create at the load time

    private Ghi() {
        System.out.println("Instance created");
    }

    public static synchronized Ghi  getInstance() {

        if(obj==null){
            obj = new Ghi(); // need to check here that there is already object created or not(instance)
        }
        return obj;
    }

    // here it is pringint "Instance created"); 2 times as 2 insgtance are getting created

    // now use synchronied method : it will stop other thread run till once completed

    // any issue= > yes
    // synchronie can slow our things down and the respinse time can delay
    // so instead of creatinf metthod synchronised, do double check


}