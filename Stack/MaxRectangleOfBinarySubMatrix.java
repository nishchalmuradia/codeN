import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class MaxRectangleOfBinarySubMatrix {

    public static void main(String[] args) {
        int n = 4, m = 4;
        int array[][] = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };


        System.out.print("Max Area: " + getMaxRectangleOfBinarySubMatrix(array, n, m));

    }

    private static Integer getMaxRectangleOfBinarySubMatrix(int arr[][], int n, int m) {
        /*Steps:
        1. Break 2 D Array into 4 1-D array
        2.At low level 0, mark whole value
        3.Call MAH(MaximumAreaOfHIstogam FUcntion) for all
        4. Return max of it.*/
        Vector<Integer> HistogramAreas = new Vector();
        int[] v = new int[m];
        //1. Break 2D into 1 D arrays;
        for (int j = 0; j < m; j++) {
            v[j] = arr[0][j];
        }
        HistogramAreas.add(MAximumAreaHistogramaKaMAH(v));


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    v[j] = 0;
                } else {
                    v[j] += arr[i][j];
                }
            }
            HistogramAreas.add(MAximumAreaHistogramaKaMAH(v));
        }

        return Collections.max(HistogramAreas);
    }

    private static int MAximumAreaHistogramaKaMAH(int[] inputList) {
        Vector<Integer> nsLeft = nSLeft(inputList);
        Vector<Integer> nsRight = nSRight(inputList);

        System.out.println();
        for (int i = 0; i < nsRight.size(); i++) {
            nsRight.set(i, (nsRight.get(i) - nsLeft.get(i) - 1) * inputList[i]);
        }

        return Collections.max(nsRight);
    }

    private static Vector<Integer> nSLeft(int[] inputArray) {
        Vector<Integer> left = new Vector<>();
        Stack<Stackpair> stack = new Stack<>();

        for (int i = 0; i <= inputArray.length - 1; i++) {
            if (stack.isEmpty()) {
                left.add(-1);
            } else if (!stack.isEmpty() && stack.peek().value < inputArray[i]) {
                left.add(stack.peek().index);
            } else if (!stack.isEmpty() && stack.peek().value >= inputArray[i]) {
                while (!stack.isEmpty() && stack.peek().value >= inputArray[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    left.add(-1);
                } else {
                    left.add(stack.peek().index);
                }
            }
            stack.push(new Stackpair(i, inputArray[i]));
        }
        return left;
    }

    private static Vector<Integer> nSRight(int[] inputArray) {
        Vector<Integer> right = new Vector<>();
        Stack<Stackpair> stack = new Stack<>();

        for (int i = inputArray.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                right.add(inputArray.length);

            } else if (!stack.isEmpty() && stack.peek().value >= inputArray[i]) {
                while (!stack.isEmpty() && stack.peek().value >= inputArray[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    right.add(inputArray.length);
                } else {
                    right.add(stack.peek().index);
                }

            } else if (!stack.isEmpty() && stack.peek().value < inputArray[i]) {
                right.add(stack.peek().index);

            }
            stack.push(new Stackpair(i, inputArray[i]));
        }
        Collections.reverse(right);
        return right;
    }
}
