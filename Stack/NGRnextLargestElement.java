import java.util.*;

public class NGRnextLargestElement {


    public static void main(String args[]) {
        int inputArray[] = {100, 80, 60, 70, 60, 75, 85};
        ArrayList<Integer> result = nextLargestElement(inputArray);
        Collections.reverse(result);
        for(int i=0; i<result.size();i++){
            System.out.print(result.get(i) +" ");
        }
    }

    private static ArrayList<Integer> nextLargestElement(int[] inputArray) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = inputArray.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                a.add(-1);
            } else if (!stack.isEmpty() && stack.peek() > inputArray[i]) {
                a.add(stack.peek());
                stack.push(inputArray[i]);
            }
            else if(!stack.isEmpty() && stack.peek() <= inputArray[i]){
                while (!stack.isEmpty() &&  stack.peek() <= inputArray[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    a.add(-1);
                }else{
                    a.add(stack.peek());
                }
            }
            stack.push(inputArray[i]);
        }
        return a;
    }
}
