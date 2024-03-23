package Tree.Traversals;


import java.util.LinkedList;
import java.util.Queue;

public class InsertInBT {

    public static void insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // offer is used for inserting the value only, it dont throw the execption for the size and
        // insert method does throw the exception

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left == null) {
                node.left = new TreeNode(data);
                return;
            } else {
                queue.offer(node.left);
            }

            if (node.right == null) {
                node.right = new TreeNode(data);
                return;
            } else {
                queue.offer(node.right);
            }
        }

    }


    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.left.left.left = new TreeNode(8);
        node.left.left.right = new TreeNode(9);

        insert(node, 25);
        System.out.println(node.left.right.value);


    }
}
