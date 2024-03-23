package creational.proptotypeDeepCopy.prototype;

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop bs = new BookShop();
        bs.setShopName("Novelty");
        bs.loadData();
        // find the data from the database



        // so her4e instead of fetching the edata from the dfb again we are just creating the copy of rthe obkect bs here
        // we need to use clone method but we need clonable interface that is market interface(woth no method)
        // clone is protected method so we need to override it in our bookshop close
        // this type of copying is called as shallow copy and it is defaulr
        // we are just overriding the clone method here
        BookShop bs1 = bs.clone();

        // removing form first copy objecxt
        bs.getBooks().remove(2);
        bs1.setShopName("A1");


        System.out.println(bs);
        System.out.println(bs1);


    }
}
