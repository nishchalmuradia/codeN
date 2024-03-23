package creational.builder;

class Phone {


    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public Phone(String os, int ram, String processor, double screenSize, int battery) {
        super();
        this.os = os;
        this.ram = ram;
        this.processor = processor;
        this.screenSize = screenSize;
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                '}';
    }
}

public class Shop{
    public static void main(String[] args) {
        // this is where we are not using builder so we need to pass everything in the sequence
        // we need to apss all the varible to create the obkext of the phone class.
        // so when we want to pass only desired elemnts and want to craete the obkjext then use the builder
        //checkour builde rexmaole
        Phone p = new Phone("and", 12, "intel", 14.0, 22000);
        System.out.println(p);

        //=================================================================
        System.out.println("=================================================================");

        Phone p1 = new PhoneBuilder().setBattery(3000).setOs("linux").setRam(16).getPhone();
        System.out.println(p1);

    }


}



//Builder here:
// instead of phone use phoneBuilder
class PhoneBuilder {
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public Phone getPhone(){
        return new Phone(os,ram,processor,screenSize,battery);
    }
}