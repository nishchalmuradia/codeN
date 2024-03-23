package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class CombinationalSum {
    //Given an array of distinct integers candidates and a target integer target, return a list of all unique
    // combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, ds, ans, target, arr);
        for (List<Integer> i : ans) {
            System.out.println(i);
        }
    }

    private static void findCombinations(int index, List<Integer> ds, List<List<Integer>> ans, int target, int[] arr) {
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[index] <= target) {
            ds.add(arr[index]);
            findCombinations(index, ds, ans, target - arr[index], arr);

            ds.remove(ds.size() - 1);
        }
        findCombinations(index + 1, ds, ans, target, arr);
    }
}
