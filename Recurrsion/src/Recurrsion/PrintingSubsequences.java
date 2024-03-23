package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class PrintingSubsequences {
    //print all subsequences of a given array
    // check the notebook for explanation and how rec. is working here.

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        List<Integer> result = new ArrayList<>();
        printSubSequences(0, result, arr);
    }

    private static void printSubSequences(int index, List<Integer> list, int[] arr) {
        if (index == arr.length) {
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        printSubSequences(index + 1, list, arr);
        list.remove(list.size() - 1);
        printSubSequences(index + 1, list, arr);

    }
}
