import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostFixUsingStack {


    public static void main(String args[]) {
        String expression = "a+b*c+d";
        System.out.print("PostFix: " + convertInfixToPostfix(expression));
    }


    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    private static String convertInfixToPostfix(String expression) {
        String resultString = new String("");
        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                resultString += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    resultString += c;
                    stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    resultString += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }

        if (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                System.out.println("Bad String");
            }
            resultString += stack.peek();
            stack.pop();
        }

        return resultString;
    }
}
