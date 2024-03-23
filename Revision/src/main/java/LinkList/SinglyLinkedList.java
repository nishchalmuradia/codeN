package LinkList;

public class SinglyLinkedList {

    Node head;

    public void insertAtEnd(int num) {

        Node node = new Node();// creating obj of node
        node.data = num;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node n = head;// just bcz we dont want to change the head

            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }

    }

    public void insertAt(int num, int index) {
        Node node = new Node();
        node.data = num;
        node.next = null;

        if (index == 0) {
            insertAtStart(num);
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;


        }
    }

    public void insertAtStart(int num) {
        Node node = new Node();
        node.data = num;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void delete(int num) {
        int index = 0;
        Node n = head;
        Node n1 = head;
        if (head == null) {
            System.out.println("No element to delete");
        } else {
            while (n.data != num) {
                n = n.next;
                index++;
            }

            if (index == 0) {
                head = n.next;
            } else {
                for (int i = 0; i < index-1; i++) {
                    n1 = n1.next;
                }
                n1.next = n1.next.next;
            }
        }

    }

    public void show() {
        Node node = new Node();
        Node n = head; // head is pointing to linked list
        if (node == null) {
            System.out.println("OOPS! your linekd list is empty");
        } else {
            while (n.next != null) {
                System.out.print(n.data + ", ");
                n = n.next;
            }
            System.out.print(n.data);
        }
    }
}

