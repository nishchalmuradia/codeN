package coreJava;

class E{
        public void show1(){
            System.out.println("inside show 1");
        }
}
class F extends E{
    public void show2(){
        System.out.println("inside show 2");
    }

}
public class Upcasting {
    public static void main(String[] args) {

         E obj = new F(); // 0r we can do like this   E obj = (E)new F();
        // this is up casting basicallly F 's object is created and referring to E.
        obj.show1();


        // why the need to downcastinbg,
        // now we have object of E but we cant obj.show2, beacuse object ios of F and E is jjust referring to it.

        F obj1 = (F) obj;// down casting
        obj1.show2();


    }
}
