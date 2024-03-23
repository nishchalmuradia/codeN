package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class PrintOneSubsequenceWithSUmK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int sum = 0;
        int k = 2;
        List<Integer> ds = new ArrayList<>();
        printOnlyOneSubWithKSum(0, ds, sum, arr, k);
    }

    private static boolean printOnlyOneSubWithKSum(int index, List<Integer> ds, int sum, int[] arr, int k) {
        if (index == arr.length) {
            if (sum == k) {
                System.out.println(ds);
                return true;
            } else return false;
        }


        ds.add(arr[index]);
        sum += arr[index];

        if (printOnlyOneSubWithKSum(index + 1, ds, sum, arr, k)) return true;
        ds.remove(ds.size() - 1);
        sum -= arr[index];
        if (printOnlyOneSubWithKSum(index + 1, ds, sum, arr, k)) return true;

        return false;
    }


}
