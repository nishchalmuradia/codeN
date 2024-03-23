package Recurrsion;

public class CheckPallandrome {

    public static void main(String[] args) {
        String  str = "121";
        System.out.println(checkPallandrome(0,str.toCharArray()));
    }

    private static boolean checkPallandrome(int i, char [] ch) {
        if (i > ch.length / 2) {
        return true;
        }
        if(ch[i] != ch[ch.length-i-1]) return false;
        return checkPallandrome(i+1, ch);
    }

}
