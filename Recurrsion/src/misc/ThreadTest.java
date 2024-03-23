package misc;


class A extends Thread{
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("A");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
class B extends  Thread{
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("B");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
public class ThreadTest extends Thread{

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.start();// instrad of call show dall start tocal threads
        // we make our method names as run why?
        // beaccuse if u go insdie the start method it will only execute the run method
        // thats why we make it run
        // also we dont use succh thigns in code now a days as all the framework are provinf the threading by default
        // to us
        b.start();


        // here threading is working but our processor is so fast that when the otehr thread is trying to start first is compelting its work till
        // that thats why u will not get the ans in parallel
        // give input to 10 to 1000 , u will abnle to see the parallel processing


        // if u want to print one by one other
        // use sleep method


    }



}
