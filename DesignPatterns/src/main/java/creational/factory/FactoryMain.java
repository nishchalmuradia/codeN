package creational.factory;

interface OS {

    void specs();
}

class Android implements OS {

    @Override
    public void specs() {
        System.out.println("open source android os");
    }
}
class Ios implements OS {
    @Override
    public void specs() {
        System.out.println("Secured OS");
    }
}
class Windows implements OS {
    @Override
    public void specs() {
        System.out.println("Weird OS windows");
    }
}

//----------------------------------
//factory design
class OperatingSystemFactory {
    public OS getInstance(String str) {
        if (str.equalsIgnoreCase("OPEN")) {
            return new Android();
        } else if (str.equalsIgnoreCase("Secured")) {
            return new Ios();
        } else {
            return new Windows();
        }
    }
    // or we can also create a Interface and create diff implementation of it instead of this if else logic
    // just for example
    //checkout FactoryMethodExample\
    //
    // \]]];
}


public class FactoryMain {
    public static void main(String[] args) {

        // one way of creating object is without Design pattern
        OS obj = new Android();
        obj.specs();

        // but this is too open. we dont want to show our client the objext creation part
        // plus if we want to create the windows objec instead if android then we need to chanhe the code
        // that is a bad idea.
        // so use design patter(factory)
        System.out.println("--------------------------------------------");

        OperatingSystemFactory osf = new OperatingSystemFactory();
        OS newObj = osf.getInstance("SECURED");
        newObj.specs();

    }
}
