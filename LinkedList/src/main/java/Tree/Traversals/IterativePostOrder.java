package Tree.Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {

    /*    1. Push root to first stack.
            2. Loop while first stack is not empty
                2.1 Pop a node from first stack and push it to second stack
                2.2 Push left and right children of the popped node to first stack
            3. Print contents of second stack*/

    private static List<Integer> iterativePostOrder(TreeNode node) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        s1.push(node);
        while (!s1.isEmpty()) {
            s2.push(s1.peek());
            TreeNode current = s1.pop();

            if (current.left != null) {
                s1.push(current.left);
            }
            if (current.right != null) {
                s1.push(current.right);
            }
        }

        while (!s2.isEmpty()) {
            result.add(s2.peek().value);
            s2.pop();
        }
        return result;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.left.left.left = new TreeNode(8);
        node.left.left.right = new TreeNode(9);

        List<Integer> integers = iterativePostOrder(node);
        System.out.println(integers);
    }

}