package LinkList;

public class SinglyRunnner {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtStart(9);
        list.insertAtEnd(10);
        list.insertAtEnd(11);
        list.insertAtEnd(12);
        list.show();
        list.insertAtStart(13);
        System.out.println();
        list.show();

        list.insertAt(99, 3);
        System.out.println();
        list.show();
        list.delete(99);
        System.out.println();
        list.show();

    }
}
