package LinkedListModule;

public class DoublyLinkedList {
    Node head;

    public void insertAtEnd(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.prev = null; // created a new node

        if (head == null) {
            head = node;
        } else {
            Node n = head; // temp node for pointing head
            while (n.next != null) { //travese to find the end node so we can add new node
                n = n.next;
            }
            node.prev = n; // new nodes's previous is pointing to previous last ndoe
            n.next = node; // previous last node's next is pointing to new node.
        }

    }

    public void insertBefore(int index, int data) {
        if(index==0){
            insertAtStart(data);
        }else{
            //new node creation
            Node node = new Node();
            node.data=data;

            Node n = head;
            for(int i=0; i<index-1;i++){
                if(index!=1){
                    n=n.next;
                }
            }
            node.next=n.next;
            node.prev=n;
            n.next.prev=node;
            n.next=node;
        }

    }
    public void insertAfter(int index, int data){
        Node node = new Node();
        node.data=data; // new node

        Node n = head;

        for(int i=0; i<index;i++){
            if(index!=0){
                n=n.next;
            }
        }
        if(n.next==null){
            insertAtEnd(data);
        }else {
            node.next = n.next;
            node.prev = n;
            n.next.prev = node;
            n.next = node;
        }

    }

  /*  public void insertAtEnd( int data){


    }*/



    private void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = null; // created a new node

        node.next = head;
        head.prev = node;
        head = node;
    }

    public void show() {
        Node n = head;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }

    public void deleteAt(int index) {
        Node n = head;
        if (index == 0) {
            if (n.next == null) {
                head = null;
            } else {
                head = n.next;
            }
        } else {
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            if (n.next.next != null) {
                n.next.next.prev = n;
                n.next.prev=null;
                n.next = n.next.next;
            } else {
                n.next.prev=null;
                n.next = null;
            }

        }
    }

    public void reverse() {
        Node n1 = head;
        Node t1=null;//temp

        while (n1 != null) {
             t1 = n1.prev;
            n1.prev = n1.next;
            n1.next = t1;
            n1 = n1.prev;// interesting to be....
        }
        head=t1.prev;

    }
}
