package Tree.EasyProblems;


import java.util.Scanner;

/*    Given preorder of a binary tree, calculate its depth(or height) [starting from depth 0].
        The preorder is given as a string with two possible characters.
        ‘l’ denotes the leaf
        ‘n’ denotes internal node*/
public class DepthOfAFullBinaryTreeFromPreorder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter preorder seq: ");
        String str = sc.nextLine();


        System.out.println("Depth: " + findHeight(str, str.length()));
    }

    private static int findHeight(String str, int length) {

        int depth = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 'n') {
                depth++;
            }
        }
        return depth;
    }

}
