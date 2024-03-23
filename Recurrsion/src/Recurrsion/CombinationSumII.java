package Recurrsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    //Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
    //Each number in candidates may only be used once in the combination.
    //Note: The solution set must not contain duplicate combinations.
    //Example 1:
    //Input: candidates = [10,1,2,7,6,1,5], target = 8
    //Output:
    //[
    //[1,1,6],
    //[1,2,5],
    //[1,7],
    //[2,6]
    //]

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        combinationSum2Logic(0, result, candidates, ds, target, 0);
        return result;
    }

    private static void combinationSum2Logic(int index, List<List<Integer>> result, int[] arr, List<Integer> ds, int target, int sum) {
        if(target==0){
            result.add(new ArrayList<>(ds));
        }

        if (index <= arr.length - 1) {

            ds.add(arr[index]);
            combinationSum2Logic(index + 1, result, arr, ds, target, sum + arr[index]);
            ds.remove(ds.size() - 1);
            combinationSum2Logic(index + 1, result, arr, ds, target, sum);
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(arr);
        int target = 8;
        System.out.println(combinationSum2(arr, target));

    }


}
