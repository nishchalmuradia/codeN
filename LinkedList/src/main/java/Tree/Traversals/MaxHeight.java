package Tree.Traversals;

import static java.lang.Math.max;

public class MaxHeight {
    static int height =0;


    public  static  int getHeight( TreeNode root ){

        if(root==null){
            return 0;
        }else{
            return 1+ Math.max(getHeight(root.left), getHeight(root.right));
        }
    }


    public static void main(String args[]) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.left.left.left = new TreeNode(8);
        node.left.left.right = new TreeNode(9);
        node.left.right.left = new TreeNode(10);
        node.left.right.right = new TreeNode(11);


        System.out.println("Height of Node " + getHeight(node));
    }
}
