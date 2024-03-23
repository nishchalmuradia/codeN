package creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop  implements Cloneable{
    private String shopName;
    List<Book> books = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public void loadData(){

        for(int i=0; i<10;i++){
            Book b = new Book();
            b.setBid(i);
            b.setBname("Book " + i);
            getBooks().add(b);
        }

    }
}
