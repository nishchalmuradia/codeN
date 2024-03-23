import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0 ) {
            return result;
        }

        Hashtable<Integer, List<Character>> dials = new Hashtable<>();
        dials.put(0, Arrays.asList());
        dials.put(1, Arrays.asList());
        dials.put(2, Arrays.asList('a', 'b', 'c'));
        dials.put(3, Arrays.asList('d', 'e', 'f'));
        dials.put(4, Arrays.asList('g', 'h', 'i'));
        dials.put(5, Arrays.asList('j', 'k', 'l'));
        dials.put(6, Arrays.asList('m', 'n', 'o'));
        dials.put(7, Arrays.asList('p', 'q', 'r', 's'));
        dials.put(8, Arrays.asList('t', 'u', 'v'));
        dials.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        generateCombinations(result, digits, dials, "", 0);
        return result;
    }

    private static void generateCombinations(List<String> result, String digits, Hashtable<Integer, List<Character>> dials, String current, int index) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';
        List<Character> letters = dials.get(digit);

        for (char letter : letters) {
            generateCombinations(result, digits, dials, current + letter, index + 1);
        }
    }


}