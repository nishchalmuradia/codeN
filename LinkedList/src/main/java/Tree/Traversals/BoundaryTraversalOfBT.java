package Tree.Traversals;

public class BoundaryTraversalOfBT {

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
        boundryTraversal(node);
    }

    private static void boundryTraversal(TreeNode root) {
        /*break thi in 4 part
         * 1. store root node
         * 2. store left non leaf nodes
         * 3. store right non leaf nodes
         * 4. store leaf nodes
         * add them in a list like : 1. root, left ones, then leaf ones and the reversed right non leaf nodes*/

        System.out.print(root.value + " ");
        getNonLeafLeft(root);
        getLeafNodes(root);
        getNonLeafRight(root);

    }

    private static void getLeafNodes(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print(root.value + " ");

        }
        if (root.left != null) {
            getLeafNodes(root.left);
        }
        if (root.right != null) {
            getLeafNodes(root.right);
        }
    }

    private static void getNonLeafLeft(TreeNode root) {
        if (root.left.left != null) {
            System.out.print(root.left.value + " ");
            getNonLeafLeft(root.left);
        }
    }

    private static void getNonLeafRight(TreeNode root) {
        if (root.right.right != null) {
            System.out.print(root.right.value + " ");
            getNonLeafLeft(root.right);
        }
    }
}
