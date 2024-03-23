package coreJava;

class Threads1 extends Thread{

    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Thread2 extends Thread{
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("Hello Nishchal");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class Threads {
    public static void main(String[] args) {
        Threads1 t1 = new Threads1();
        Thread2 t2 = new Thread2();
        System.out.println(t1.getPriority());
        t1.start();
        t2.start();

    }
}
