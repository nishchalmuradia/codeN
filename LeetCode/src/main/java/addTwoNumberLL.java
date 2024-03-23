import java.math.BigInteger;

class AddTwoNumberLL {

    public static class ListNode {
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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String s1 = "";
        String s2 = "";
        ListNode head1;
        ListNode head2;
        head1 = l1;
        head2 = l2;
        ListNode n1 = l1;
        ListNode n2 = l2;

        while (n1 != null && n1.next != null) {
            s1 = s1 + n1.val;
            n1 = n1.next;
        }
        s1 = s1 + n1.val;
        s1 = new StringBuilder(s1).reverse().toString();

        while (n2 != null && n2.next != null) {
            s2 = s2 + n2.val;
            n2 = n2.next;
        }
        s2 = s2 + n2.val;
        s2 = new StringBuilder(s2).reverse().toString();

        BigInteger sum = new BigInteger(s1).add( new BigInteger(s2));


        String s3 = String.valueOf(sum);

        ListNode newNode = new ListNode();
        ListNode temp = newNode;

        newNode.val = s3.charAt(s3.length()-1) - '0';
        newNode.next = null;
        temp = newNode;

        for (int i = s3.length(); i >0; i--) {
            ListNode node = new ListNode();
            node.val = s3.charAt(i) - '0';
            node.next = null;

            temp.next = node;
            temp = temp.next;

        }
        return newNode;
    }

    public ListNode intToList(int num) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        String numStr = Integer.toString(num);
        for (int i = numStr.length() - 1; i >= 0; i--) {
            int digit = numStr.charAt(i) - '0';
            current.next = new ListNode(digit);
            current = current.next;
        }

        return dummyHead.next; // Skip the dummy node
    }

    public static void main(String[] args) {
        AddTwoNumberLL solution = new AddTwoNumberLL();
        ListNode l1 = solution.intToList(342);
        ListNode l2 = solution.intToList(465);

        ListNode listNode = addTwoNumbers(l1, l2);

    }
}