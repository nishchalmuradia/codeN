import com.sun.jdi.request.StepRequest;

import java.io.CharArrayReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PrefixToInfix {


    public static void main(String args[]){
        String str = "*+AB-CD";
        System.out.print("Infix"+ convertPrefixToInfix(str));
    }

    private static String convertPrefixToInfix(String str) {
        //reversing the string by charater array
        String reverseString="";
        for(int i =str.length()-1 ;i>=0;i--){
            reverseString+= str.charAt(i);
        }

        String result = new String("");
        Deque<String> stack = new ArrayDeque<String>();

        for(int i=0; i<str.length();i++){
            char c = reverseString.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(c+ "");
            }else{
                String a1= stack.pop();
                String a2 = stack.pop();
                stack.push(a1+c+a2);
            }
        }
       return stack.peek();
    }
}
