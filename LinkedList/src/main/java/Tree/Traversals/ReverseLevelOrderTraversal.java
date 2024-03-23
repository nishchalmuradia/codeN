package Tree.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {


    public static List<List<Integer>> reverseLevelOrderAlgo(TreeNode root) {

        // simple, use level order traversal and store levels of node in list
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> eachLevelElementList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                eachLevelElementList.add(currentNode.value);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(eachLevelElementList);
        }
        return result;
    }

    public static void reverseLevelOrder(TreeNode node) {
        List<List<Integer>> results = reverseLevelOrderAlgo(node);

        for (int i = results.size() - 1; i >= 0; i--) {
            System.out.println(results.get(i));
        }
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

        reverseLevelOrder(node);
    }
}
