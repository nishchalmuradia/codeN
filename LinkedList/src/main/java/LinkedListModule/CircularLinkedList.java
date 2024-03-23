package LinkedListModule;

public class CircularLinkedList {
    Node head;

    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        head = node;
        node.next = node;
    }

    public void insertAtEnd(int data) {
        Node node = new Node();
        node.data = data;
        Node n = head;
        while (n.next != head) {
            n = n.next;
        }
        n.next = node;
        node.next = head;
    }

    public void insertAt(int index, int data) {


        if (index == 0) {
            insertAtStart(data);
        } else {

            Node node = new Node();
            node.data = data;
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                if (index != 1) {
                    n = n.next;
                }
            }
            if (n.next == head) {
                insertAtEnd(data);
            } else {

                node.next = n.next;
                n.next = node;

            }
        }
    }

    public void show() {
        Node n = head;
        if (head == null) {
            System.out.println("Empty");
        } else {
            while (n.next != head) {
                System.out.println(n.data);
                n = n.next;
            }
            System.out.println(n.data);
        }
    }

    private void delete(int index) {
        Node n = head;
        if (index == 0 && n.next == head) {
            head = null;
        } else {
            for (int i = 0; i < index - 1; i++) {
                if (index != 1) {
                    n = n.next;
                }
            }
            if (n.next.next == head) {
                n.next = head;
            } else {
                n.next = n.next.next;
            }
        }
    }


    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        cl.insertAt(0, 11);
        cl.insertAt(1, 12);
        cl.insertAt(2, 13);
        cl.insertAt(3, 14);
        cl.insertAt(3, 15);
        cl.insertAt(3, 1111);

        // cl.delete(0);
        cl.delete(5);
        cl.show();
        System.out.println();


    }
//  10- 11->

    public void reverse() {
        //To Be implement
    }
}
