package misc;

// lets use lemda expression (onlhy work wuth functuinalo interface)
// also use anonmus class first

class F extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("B");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

public class T3 extends Thread {

    public static void main(String[] args) {

        Runnable obj1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("A");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable obj2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();


    }
    // lets do magic in T3


}
