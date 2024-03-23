package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum2 {

    public static void main(String[] args) {

        int arr[] = {1, 2, 2};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        subsetSum2(0, arr, result, ds);
        System.out.println(result);
    }

    private static void subsetSum2(int index, int[] arr, List<List<Integer>> result, List<Integer> ds) {

        result.add(new ArrayList<>(ds));

        for (int i = index; i <= arr.length - 1; i++) {
            if (i != index && arr[i] == arr[i - 1]) {
                continue;
            }
            ds.add(arr[i]);
            subsetSum2(i + 1, arr, result, ds);
            ds.remove(ds.size() - 1);
        }
    }


}

