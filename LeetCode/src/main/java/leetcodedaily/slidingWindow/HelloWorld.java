package leetcodedaily.slidingWindow;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class HelloWorld {
    public static int pairSum(ListNode head) {
        ListNode m = head;
        ListNode n = head;

        if (head == null) {
            return 0;
        }
        //get the length
        int length = getLengthLinkedList(n);
        int middle = length / 2;
        for (int i = 0; i < middle; i++) {
            m = m.next;
        }

        int max = Integer.MIN_VALUE;
        ListNode prev = null;
        ListNode curr = n;
        ListNode next = null;
        for (int i = 0; i < middle; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        n = prev;

        while (n.next != null && m.next != null) {
            if ((n.val + m.val) > max) {
                max = n.val + m.val;
            }
            n = n.next;
            m = m.next;
        }
        if ((n.val + m.val) > max) {
            max = n.val + m.val;
        }
        return max;

    }

    public static int getLengthLinkedList(ListNode head) {
        ListNode n = head;
        int length = 1;
        while (n.next != null) {
            n = n.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode an = new ListNode();
        an.val = 4;
        an.next = new ListNode(2);
        an.next.next = new ListNode(2);
        an.next.next.next = new ListNode(3);
        pairSum(an);
    }
}