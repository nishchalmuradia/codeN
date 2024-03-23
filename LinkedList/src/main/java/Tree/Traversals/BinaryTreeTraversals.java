package Tree.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversals {


    public static List<Integer> preOrderTraversal(TreeNode root) {

        /*1.Visit Root Node
         * 2.Visit  Left
         * 3. Visit Right*/
        List<Integer> preOrderList = new ArrayList<>();
        if (root == null) {
            return preOrderList;
        }

        preOrderList.add(root.value);
        preOrderList.addAll(preOrderTraversal(root.left));
        preOrderList.addAll(preOrderTraversal(root.right));
        return preOrderList;


    }

    public static List<Integer> inOrderTraversal(TreeNode root) {

        List<Integer> InOrderList = new ArrayList<>();
        if (root == null) {
            return InOrderList;
        }

        InOrderList.addAll(inOrderTraversal(root.left));
        InOrderList.add(root.value);
        InOrderList.addAll(inOrderTraversal(root.right));
        return InOrderList;
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> InOrderList = new ArrayList<>();
        if (root == null) {
            return InOrderList;
        }
        InOrderList.addAll(postOrderTraversal(root.left));
        InOrderList.addAll(postOrderTraversal(root.right));
        InOrderList.add(root.value);
        return InOrderList;
    }

    public static void levelOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode current = queue.poll(); // remove current element and print
                System.out.print(current.value + " ");

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }

            }
            System.out.println();
        }
    }

    public static void main(String args[]) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);


        List<Integer> pre = preOrderTraversal(node);
        List<Integer> in = inOrderTraversal(node);
        List<Integer> post = postOrderTraversal(node);

        System.out.print("Pre Order :");
        for (int i : pre) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.print("In Order :");
        for (int i : in) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.print("Post Order :");
        for (int i : post) {
            System.out.print(i + ", ");
        }

        System.out.println();
        System.out.print("Level Order :");
        levelOrderTraversal(node);

    }
}
