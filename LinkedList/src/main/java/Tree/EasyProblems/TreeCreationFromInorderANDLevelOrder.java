package Tree.EasyProblems;

import Tree.TreeNode;

public class TreeCreationFromInorderANDLevelOrder {


    public static void main(String[] args) {
        int inOrder[] = {4, 8, 10, 12, 14, 20, 22};
        int levelOrder[] = {20, 8, 22, 4, 12, 10, 14};
        TreeNode resultTree = null;
        int inStart = 0;
        TreeNode tree = createBinaryTree(inOrder, levelOrder, resultTree, inStart, levelOrder.length - 1);

        printTree(tree);
    }

    private static void printTree(TreeNode node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.value + " ");
            printTree(node.right);
        }
    }


    private static TreeNode createBinaryTree(int[] inOrder, int[] levelOrder, TreeNode resultTree, int inStart,
                                             int inEnd) {

        if (inStart > inEnd)
            return null;

        if (inStart == inEnd)
            return new TreeNode(inOrder[inStart]);
        boolean found = false;
        int foundElementIndex = 0;

        for (int i = 0; i < levelOrder.length-1; i++) {
            int data = levelOrder[i];
            for (int j = inStart; j < inEnd; j++) {
                if (inOrder[j] == levelOrder[i]) {
                    resultTree = new TreeNode(data);
                    foundElementIndex = j;
                    found = true;
                    break;
                }
            }
            if (found == true) {
                break;
            }
        }
        resultTree.setLeft(createBinaryTree(inOrder, levelOrder, resultTree, inStart, foundElementIndex - 1));
        resultTree.setRight(createBinaryTree(inOrder, levelOrder, resultTree, foundElementIndex + 1, inEnd));

         return resultTree;

    }
}
