package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class PallandromePartitioning {

    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        pallandromepartitioning(0, str, result, path);
        System.out.println(result);

    }

    private static void pallandromepartitioning(int index, String str, List<List<String>> result, List<String> path) {
        if (index == str.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < str.length(); i++) {
            if (isPallandrome(str, index, i)) {
                path.add(str.substring(index, i + 1));
                pallandromepartitioning(i + 1, str, result, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPallandrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }

        return true;

    }
}
