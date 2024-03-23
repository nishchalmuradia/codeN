import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {

        // just do inorder traversal and do the range checking.
        //inorder will be : 3,5,7,10,15,18
        List<Integer> result = inorderTraversal(root);
        int sum =0;
        for(int i=0; i<result.size();i++){
            if(result.get(i) >=low && result.get(i) <=high){
                sum= sum + result.get(i);
            }
        }
        return sum;


    }

    public static List<Integer>  inorderTraversal(TreeNode root){

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> sc = new Stack();
        TreeNode currentNode = root;

        while(currentNode !=null || ! sc.isEmpty()){

            while(currentNode.left !=null){
                sc.add(currentNode.left);
                currentNode = currentNode.left;
            }
            //pop now
            TreeNode popped = sc.pop();
            result.add(popped.val);
            currentNode = currentNode.right;
        }
        return result;


    }
}