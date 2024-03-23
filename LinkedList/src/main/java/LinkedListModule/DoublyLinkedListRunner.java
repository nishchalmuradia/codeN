package LinkedListModule;

public class DoublyLinkedListRunner {

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtEnd(10);
        doublyLinkedList.insertAtEnd(12);
        doublyLinkedList.insertAtEnd(13);
        doublyLinkedList.insertAtEnd(14);

        doublyLinkedList.insertBefore(1,11);

        doublyLinkedList.insertAfter(4,15);
        doublyLinkedList.show();
        System.out.println();
        doublyLinkedList.reverse();
        doublyLinkedList.show();
    }
}
