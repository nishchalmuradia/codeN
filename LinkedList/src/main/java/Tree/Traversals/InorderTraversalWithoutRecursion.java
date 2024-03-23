package Tree.Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalWithoutRecursion {


    public static List<Integer> inorderWithoutRecursion(TreeNode root) {

        Stack<TreeNode> sc = new Stack();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode currentNode = root;

        while (currentNode != null || !sc.isEmpty()) {


            while (currentNode != null) {
                sc.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = sc.pop();
            result.add(currentNode.value);
            currentNode = currentNode.right;
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
        List<Integer> integers = inorderWithoutRecursion(node);
        System.out.println(integers);
    }
}
