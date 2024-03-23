package coreJava;

public class Runnabele {
    public static void main(String[] args) {
        Runnable t11 = () -> { // we can use lamda here beacuse Runnable have only one methof and marker interface it is.
            for (int i = 0; i <= 5; i++) {
                System.out.println("hi");

            }
        };
        Runnable t12 = () -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println("Hello Nishchal");

            }
        };

        Thread t1 = new Thread(t11);
        Thread t2 = new Thread(t12);
        t1.start();
        t2.start();

    }
}
