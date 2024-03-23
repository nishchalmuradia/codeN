package Tree.EasyProblems;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CousinsCheckinBT {


    public static void main(String[] args) {

        TreeNode node = new TreeNode(26);
        node.left = new TreeNode(10);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(6);
        node.right.left = new TreeNode(9);

        Scanner sc = new Scanner(System.in);
        System.out.println("enter n1: ");
        int n1 = sc.nextInt();
        System.out.println("enter n2: ");
        int n2 = sc.nextInt();
        System.out.println("is siblings: " + isCousins(node, n1, n2));

    }

    private static boolean isCousins(TreeNode root, int n1, int n2) {

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        TreeNode parentofN1 = null;
        TreeNode parentofN2 = null;
        if (root == null) {
            System.out.println("No findings, empty tree");
            return false;
        }

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                if (currentNode.left.value == n1) {
                    parentofN1 = currentNode;
                }
                if (currentNode.left.value == n2) {
                    parentofN2 = currentNode;
                }

                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                if (currentNode.right.value == n1) {
                    parentofN1 = currentNode;
                }
                if (currentNode.right.value == n2) {
                    parentofN2 = currentNode;
                }
                queue.offer(currentNode.right);
            }
        }
        if (parentofN1 == parentofN2) {
            return true;
        }
        return false;
    }
}
