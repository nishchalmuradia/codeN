package Tree.Traversals;

import java.util.Stack;

public class IterativePreOrder {

    /* PREORDER + NLR
    1. take a stack
    2. add root to stack
    3. pop the root from stack and print it
    4. Add right then left child
    5. We did right first and lef second because we want to print left first here and basically the later we add in
    stack , the sonner we print form it. that's why we did so.
    6. Thats it, do this till the stack will become empty stack*/
    public static void iterativePreOrderTraversal(TreeNode root) {
        Stack<TreeNode> sc = new Stack<>();
        if (root == null) {
            return;
        }

        sc.push(root);

        while (!sc.isEmpty()) {
            TreeNode current = sc.peek();
            System.out.print(current.value + " ");

            //popping
            sc.pop();

            // inserting right child
            if (current.right != null) {
                sc.add(current.right);
            }
            //inserting left child
            if (current.left != null) {
                sc.add(current.left);
            }
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
        iterativePreOrderTraversal(node);

    }
}
