package creational.singleton;

public class ImprovedSynchronizedSingleton {

    public static void main(String[] args) {

// lets create threads
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Jkl obj1 = Jkl.getInstance();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Jkl obj1 = Jkl.getInstance();
            }
        });
        t1.start();
        t2.start();


    }

}

class Jkl {
    private static Jkl obj;// dont initilise the object so it will not create at the load time

    private Jkl() {
        System.out.println("Instance created");
    }

    public static  Jkl getInstance() {

        if (obj == null) {
            synchronized (Jkl.class) {
                if (obj == null) {
                    obj = new Jkl(); // need to check here that there is already object created or not(instance)
                }
            }
        }
        return obj;
    }




}