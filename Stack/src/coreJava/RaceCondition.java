package coreJava;

class Counter {
    int count;

    synchronized void increment() {
        count++;
    }
}

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable t11 = () -> { // we can use lamda here beacuse Runnable have only one methof and marker interface it is.
            for (int i = 1; i <= 1000; i++) {
                c.increment();

            }
        };
        Runnable t12 = () -> {
            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(t11);
        Thread t2 = new Thread(t12);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);

    }
}
