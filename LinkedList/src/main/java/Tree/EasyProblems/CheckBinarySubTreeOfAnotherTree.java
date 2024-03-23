package Tree.EasyProblems;

import Tree.TreeNode;

/*Given two binary trees, check if the first tree is a subtree of the second one.
A subtree of a tree T is a tree S consisting of a node in T and all of its descendants
in T. The subtree corresponding to the root node is the entire tree; the subtree corresponding
to any other node is called a proper subtree.*/
public class CheckBinarySubTreeOfAnotherTree {


    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1 = new TreeNode(2);
        tree1 = new TreeNode(3);
        tree1 = new TreeNode(4);
        tree1 = new TreeNode(5);

        TreeNode tree2 = new TreeNode(2);
        tree2 = new TreeNode(4);
        tree2 = new TreeNode(5);
    }

}
