package leetcodedaily.recurrsion;

import java.util.HashMap;
import java.util.Map;

public class PallandromeCheck {


    public static void main(String[] args) {
        String str = "MADAM";
        System.out.println(checkPalindrome(0, str.toCharArray()));

    }

    private static boolean checkPalindrome(int i, char[] ch) {
        if (i >= ch.length / 2) return true;
        if (ch[i] != ch[ch.length - i - 1])  return false;
        return checkPalindrome(i + 1, ch);
    }
}
