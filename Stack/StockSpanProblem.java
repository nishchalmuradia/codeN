import java.util.*;

public class StockSpanProblem {



    /*The stock span problem is a financial problem where we have a series of N daily price quotes for a
    stock and we need to calculate the span of the stock’s price for all N days. The span Si of the stock’s
    price on a given day i is defined as the maximum number of consecutive days just before the given day, for
    which the price of the stock on the current day is less than its price on the given day.*/

    //Solution: here if we observe , it is exactly the
    public static void main(String atrgs[]) {
        int inputArray[] = {100, 80, 60, 70, 60, 75, 85};
        Vector<Integer> v = stockSPabNGLeft(inputArray);
//Now fo v = i-v[i];

        for (int i = 0; i < v.size(); i++) {
            v.set(i, i - v.get(i));
            System.out.print(v.get(i) + " ");
        }
    }

    private static Vector<Integer> stockSPabNGLeft(int[] inputArray) {
        Vector<Integer> response = new Vector<>();
        Stack<Stackpair> stack = new Stack<>();

        for (int i = 0; i <= inputArray.length - 1; i++) {
            if (stack.isEmpty()) {
                response.add(-1);

            } else if (!stack.isEmpty() && (stack.peek().value > inputArray[i])) {
                response.add(stack.peek().index);
            } else if (!stack.isEmpty() && stack.peek().value <= inputArray[i]) {
                while (!stack.isEmpty() && stack.peek().value <= inputArray[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    response.add(-1);
                } else {
                    response.add(stack.peek().index);
                }
            }
            stack.push(new Stackpair(i, inputArray[i]));
        }
        return response;
    }
}
