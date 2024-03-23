package LinkedListModule;

public class LinkedList {

    Node head;  // head node to start

    public void insert(int data) {

        Node node = new Node(); // object of Node to craete our node as per the input
        node.data = data;
        node.next = null;

        if (head == null) { // checking here that the linked list have any element or not, like
            head = node;       // if we have only first node then we have to make it head node
        } else {
            Node n = head; // now we have to traves till end (the next of node that contains null)
            while (n.next != null) {   // and then we (n is our temp. node for traversing) can add our
                n = n.next;           // new node to the linked list.
            }
            n.next = node;
        }
    }

    public void show() {
        Node n;
        n = head;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next; // for shifting to the next node
        }
        System.out.println(n.data);// beacuse we printed till not null, but alsp have tp print
        //the elment that contains null in their next
    }

    public void insertAtStart(int data) {
        Node node = new Node(); // object of Node to craete our node as per the input
        node.data = data;
        node.next = null;

        if (head == null) { // checking here that the linked list have any element or not, like
            head = node;       // if we have only first node then we have to make it head node
        } else {
            node.next = head;
            head = node;
        }
    }

    public void insertAt(int index, int data) {
        Node node = new Node(); // object of Node to create our node as per the input
        node.data = data;
        node.next = null;

        if (index == 0) {
            insertAtStart(data); // for 0th index
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) { // only till index beacuse temp will point the next node
                n = n.next;                  // by n.next, and we need one before .
            }
            node.next = n.next; // n.next means node temp(n) will point to next whole node and we give this nod to node's next
            n.next = node;
        }
    }

    public void deleteAt(int index) {

        if (index == 0) {
            head = head.next;

        } else {
            Node n = new Node();// craeting a temp node to trace the all Linkedlist
            n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n.next = n.next.next;
        }
    }

    public int getLength() {

        if (head == null) {
            return 0;
        } else {
            Node n = head;
            int length = 1;
            while (n.next != null) {
                length++;
                n = n.next;
            }
            return length;
        }

    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
}
