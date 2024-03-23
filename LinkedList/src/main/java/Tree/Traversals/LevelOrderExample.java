package Tree.Traversals;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderExample {


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);


        levelOrder(node);
    }

    private static void levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {

            int queueLength = queue.size();
        for (int i = 0; i < queueLength; i++) {
            TreeNode polledElement = queue.poll();
            System.out.print(polledElement.value + " ");
                if (polledElement.left != null) {
                    queue.add(polledElement.left);
                }

                if (polledElement.right != null) {
                    queue.add(polledElement.right);
                }
            }
            System.out.println();

        }

    }
}
