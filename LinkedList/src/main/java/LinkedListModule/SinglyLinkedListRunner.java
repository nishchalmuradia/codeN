package LinkedListModule;

public class SinglyLinkedListRunner {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insert(18);
        list.insert(45);
        list.insert(12);
        list.reverse();
        list.insertAtStart(25);
        list.insertAt(1, 55);

        list.show();
        System.out.println();
        list.deleteAt(2);
        list.show();

        System.out.println("length: " + list.getLength());



        System.out.println("after reverse");
        list.show();
    }
}
