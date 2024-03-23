package Tree.Traversals;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraversal {

    private static List<List<TreeNode>> diagonalTraversal(TreeNode root) {

        List<List<TreeNode>> result = new ArrayList<>();
        List<TreeNode> levelList = new ArrayList<>();
        if (root == null) {
            return result;
        }
        levelList.add(root);
        while (root.right != null) {
            levelList.add(root.right);
            root = root.right;
        }
        result.add(levelList);
        for (int i = 0; i < result.size(); i++) {
            List<TreeNode> treeNodes = result.get(i);
            List<TreeNode> nextLevelLists = new ArrayList<>();
            for (int j = 0; j < treeNodes.size(); j++) {
                if (treeNodes.get(j).left != null) {
                    nextLevelLists.add(treeNodes.get(j).left);

                    if (treeNodes.get(j).left.right != null) {
                        nextLevelLists.add(treeNodes.get(j).left.right);
                    }
                }
            }
            if (!nextLevelLists.isEmpty()) {
                result.add(nextLevelLists);
            }
        }

        return result;
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
        List<List<TreeNode>> results = diagonalTraversal(node);
        for (int i = 0; i < results.size(); i++) {
            List<TreeNode> treeNodes = results.get(i);
            for (int j = 0; j < treeNodes.size(); j++) {
                System.out.print(treeNodes.get(j).value + " ");
            }
            System.out.println();
        }
    }

}
