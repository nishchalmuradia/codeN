import java.util.*;

public class LargestRectangularAreaOfHistogram {

    public static void main(String args[]) {
        int inputArray[] = {6, 2, 5, 4, 5, 1, 6};
        Vector<Integer> result = largestRectAreaOfHistorgram(inputArray);
    }

    private static Vector<Integer> largestRectAreaOfHistorgram(int[] inputList) {
        Vector<Integer> nsLeft = nSLeft(inputList);
        Vector<Integer> nsRight = nSRight(inputList);

        System.out.print("left");
        for (int i : nsLeft
        ) {
            System.out.print(i + " ");

        }
        System.out.println();
        System.out.print("Right");
        for (int i : nsRight
        ) {
            System.out.print(i + " ");

        }

        System.out.println();
        for (int i = 0; i < nsRight.size(); i++) {
            nsRight.set(i, (nsRight.get(i) - nsLeft.get(i) - 1) * inputList[i]);
        }

        System.out.print("MAX AREA IS : " + Collections.max(nsRight));
        return nsLeft;
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

