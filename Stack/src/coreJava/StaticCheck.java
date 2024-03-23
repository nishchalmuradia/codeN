package coreJava;

class  Mobile{
    String battery;
    static String brand;

    public void show(){
        System.out.println(battery+ " " + brand);
    }
}
public class StaticCheck {

    public static void main(String[] args) {
        Mobile m1 = new Mobile();
        m1.battery="powerful";
        Mobile.brand="samsung";
        m1.show();

        Mobile m2 = new Mobile();
        m1.battery="powerful";
        Mobile.brand="Nokia";
        m1.show();
    }


}
