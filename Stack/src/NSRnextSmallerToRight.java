import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class NSRnextSmallerToRight {


    public static void main(String atrgs[]) {
        int inputArray[] = {1,3,0,0,1,2,4};
        ArrayList<Integer> result = nsRight(inputArray);
        Collections.reverse(result);
        for (Integer a : result
        ) {
            System.out.print(a + ",");

        }
    }

    private static ArrayList<Integer> nsRight(int[] inputArray) {
        ArrayList<Integer> response = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = inputArray.length - 1; i>=0; i--) {
            if (stack.isEmpty()) {
                response.add(-1);
                stack.push(inputArray[i]);
            } else if (!stack.isEmpty() && stack.peek() > inputArray[i]) {
                while(!stack.isEmpty() && stack.peek() > inputArray[i]){
                        stack.pop();
                }
                if(stack.isEmpty()){
                    response.add(-1);
                }else
                {
                    response.add(stack.peek());
                }
                stack.push(inputArray[i]);
            } else if (!stack.isEmpty() && stack.peek() <= inputArray[i]) {
                response.add(stack.peek());
                stack.push(inputArray[i]);
            }
        }
        return response;
    }
}
