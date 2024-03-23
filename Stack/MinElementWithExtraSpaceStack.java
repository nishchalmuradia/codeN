import java.util.Stack;

public class MinElementWithExtraSpaceStack {
    Stack<Integer> s;
    Stack<Integer> ss;
    Integer a;


    public MinElementWithExtraSpaceStack() {

    }


    /* Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(),
     isFull() and an additional operation getMin() which should return minimum element from the SpecialStack.
     All these operations of SpecialStack must have a time and space complexity of O(1).
     Note: To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, lists, etc
 */
    public static void main(String[] args) {
        MinElementWithExtraSpaceStack s = new MinElementWithExtraSpaceStack();
        s.push(3);
        s.push(5);
        System.out.println(s.getMin());
        s.push(2);
        s.push(1);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        s.peek();

    }

    private int getMin() {
        return ss.peek();
    }
    private int peek() {
        return s.peek();
    }


    void push ( int a){
        s.push(a);
        if (ss.isEmpty() || (a <= ss.peek())) {
            ss.push(a);
        }
        return;
    }

        int pop ( ){
        if (s.isEmpty()) {
            return -1;
        }
        int ans = s.peek();
        s.pop();
        if (ans == ss.peek()) {
            ss.pop();
        }
        return ans;
    }
    }