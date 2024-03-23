package Recurrsion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum1 {

    //Return all subset sums of 'nums' in a non-decreasing order.
    //Note:
    //Here subset sum means sum of all elements of a subset of 'nums'. A subset of 'nums' is an array formed by removing some (possibly zero or all) elements of 'nums'.
    //For example
    //Input: 'nums' = [1,2]
    //
    //Output: 0 1 2 3
    public static void main(String[] args) {

        int arr[] = {1, 2};
        List<Integer> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        subsetSum(0, arr, result, ds, 0);
        Collections.sort(result);
        System.out.println(result);

        List<Integer> resultNew = new ArrayList<>();
        subsetSumWithoutDS(0, arr, resultNew, 0);
        Collections.sort(resultNew);
        System.out.println(resultNew);
    }

    // think : this data structure ds has no role here, so writing another fucniton wthout ds
    private static void subsetSum(int index, int[] arr, List<Integer> result, List<Integer> ds, int sum) {
        if (index == arr.length) {
            result.add(sum);
        }
        if (index <= arr.length - 1) {
            ds.add(arr[index]);
            subsetSum(index + 1, arr, result, ds, sum + arr[index]);
            ds.remove(ds.size() - 1);
            subsetSum(index + 1, arr, result, ds, sum);
        }

    }

    private static void subsetSumWithoutDS(int index, int[] arr, List<Integer> result, int sum) {
        if (index == arr.length) {
            result.add(sum);
        }
        if (index <= arr.length - 1) {
            subsetSumWithoutDS(index + 1, arr, result, sum + arr[index]);
            subsetSumWithoutDS(index + 1, arr, result, sum);
        }

    }
}
