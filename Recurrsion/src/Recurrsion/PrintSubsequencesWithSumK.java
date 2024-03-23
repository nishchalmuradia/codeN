package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequencesWithSumK {
    //print all subsequence whose sum is 2
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int sum = 0;
        List<Integer> ds = new ArrayList<>();
        printSubWithKSum(0, ds, sum, arr);
    }

    private static void printSubWithKSum(int index, List<Integer> ds, int sum, int[] arr) {

        if (index == arr.length) {
            if (sum == 2) {
                System.out.println(ds);
            }
            return;
        }
        ds.add(arr[index]);
        sum += arr[index];



        //pick case
        printSubWithKSum(index + 1, ds, sum, arr);
        ds.remove(ds.size() - 1);
        sum -= arr[index];

        //unpick case
        printSubWithKSum(index + 1, ds, sum, arr);
    }

}
