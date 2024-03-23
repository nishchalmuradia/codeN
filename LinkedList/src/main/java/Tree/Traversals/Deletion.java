package Tree.Traversals;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Deletion {


    /* 1. level order traversal is magic (BFS algo)

    1. find out the main value thar needs tobe deleted with tht level order
    2. along with this we can keep track of the parent Node (last visited parent) node so we can find the right pof that node
    to consider it as the last node , so then we can delete it with the help of parent.

    then we can just exhcnage the target node with the last node and free the last node with the help of
    parent node of last node.
           */
    private static TreeNode deleteTheNode(TreeNode root, int key) {

        // Level order = BFS

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode lastVisited = null; // our parent
        TreeNode nodeTobeDeleted = null;
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.value == key) {
                nodeTobeDeleted = temp;
            }
            //check left
            if (temp.left != null) {
                lastVisited = temp;
                queue.offer(temp.left);
            }
            //check right(we are putting this condition after left son we can get lastvisited)
            if (temp.right != null) {
                lastVisited = temp;
                queue.offer(temp.right);
            }
// till now temp is out last node that is deleted from the queue that mens it is the last node and that we can use
            // for assigning the key node
        }

        if (nodeTobeDeleted != null) {
            nodeTobeDeleted.value = temp.value;
        }
        if (nodeTobeDeleted.right != null) {
            nodeTobeDeleted.right = null;
        } else {
            nodeTobeDeleted.left = null;
        }
        return root;
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


        //before
        List<Integer> integers = BinaryTreeTraversals.inOrderTraversal(node);
        for (int i : integers
        ) {
            System.out.print(i + " ");
        }
        System.out.println();

        //delete the  node
        TreeNode treeNode = deleteTheNode(node, 5);


        // print the new Tree:
        List<Integer> newList = BinaryTreeTraversals.inOrderTraversal(treeNode);
        for (int i : newList
        ) {
            System.out.print(i + " ");
        }
    }

}
