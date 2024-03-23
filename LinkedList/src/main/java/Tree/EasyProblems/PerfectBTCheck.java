package Tree.EasyProblems;

import Tree.Traversals.TreeNode;


/* In computer science, a perfect binary tree is a binary tree in which all interior nodes have two children and all
 leaves have the same depth or level. In other words, every level of the tree is completely filled, except
 for possibly the last level, which is filled from left to right.*/
public class PerfectBTCheck {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(26);
        node.left = new TreeNode(10);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(6);
        node.right.left = new TreeNode(8);
        node.right.right = new TreeNode(9);

        System.out.println(isPerfectBT(node));

    }

    private static boolean isPerfectBT(TreeNode root) {

        int depth = getDepth(root);

        return isPerfectUtil(root, depth, 0);
    }

    private static boolean isPerfectUtil(TreeNode root, int depth, int level) {
        if (root == null) {
            return true;
        }
        // If a leaf node is encountered, check if it is at the same level as the leftmost leaf node
        if (root.left == null && root.right == null) {
            return (depth == level + 1);
        }

        // If a node has only one child, the binary tree is not perfect

        if (root.left == null || root.right == null) {
            return false;
        }
        // Recursively check left and right subtrees
        return isPerfectUtil(root.left, depth, level + 1) && isPerfectUtil(root.right, depth, level + 1);

    }

    private static int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}
