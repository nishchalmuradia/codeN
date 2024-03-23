package creational.singleton;

public class SingletonbyEnum {
    public static void main(String[] args) {
        Mno obj = Mno.INSTANCE;
        obj.i = 12;
        System.out.println(obj.i);

        Mno obj2 = Mno.INSTANCE;
        obj2.i = 1111;
        System.out.println(obj.i);

        // here only one refrence is creating thatsb why u are seeing the values is getting udpated o firt objct only

    }

}

enum Mno {
    INSTANCE;
    int i;

    public void show() {
        System.out.println(i);
    }
}