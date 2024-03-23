package Tree.EasyProblems;

import Tree.Traversals.TreeNode;

/*
Write a function that returns true if the given Binary Tree is SumTree else false.
 A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present
 in its left subtree and right subtree. An empty tree is SumTree and the sum of an empty tree can
 be considered as 0. A leaf node is also considered as SumTree.
*/
public class SumTreeCheck {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(26);
        node.left = new TreeNode(10);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(6);
        node.right.left = new TreeNode(3);

        System.out.println(isSumTree(node));

    }

    private static boolean isSumTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        return root.value == leftSum + rightSum && isSumTree(root.left) && isSumTree(root.right); // here we are chceking
        //for subtrees too.

    }

    public static int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.value;
        }
        return node.value + getSum(node.left) + getSum(node.right);
    }
}
