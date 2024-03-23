import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class NGLnextGreaterToLeft {


    public static void main(String atrgs[]) {
        int inputArray[] = {100, 80, 60, 70, 60, 75, 85};
        ArrayList<Integer> result = nGLeft(inputArray);
        for (Integer a : result
        ) {
            System.out.print(a + ",");

        }
    }

    private static ArrayList<Integer> nGLeft(int[] inputArray) {
        ArrayList<Integer> response = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= inputArray.length - 1; i++) {
            if (stack.isEmpty()) {
                response.add(-1);
            } else if (!stack.isEmpty() && stack.peek() > inputArray[i]) {
                response.add(stack.peek());
            } else if (!stack.isEmpty() && stack.peek() <= inputArray[i]) {
                while (!stack.isEmpty() && stack.peek() <= inputArray[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    response.add(-1);
                } else {
                    response.add(stack.peek());
                }
            }
            stack.push(inputArray[i]);
        }
        return response;
    }
}
