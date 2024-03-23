package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfArrayORString {


    public static void main(String[] args) {

        int arr[] = {1, 2, 3};
        boolean[] marker = new boolean[arr.length];
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        getPermutes(arr, marker, ds, result);
        System.out.println(result);

        //Better Approach without extra space, better space complexity (No DS needed here)
        List<List<Integer>> resultNew = new ArrayList<>();
        getPermutesWithoutExtraDS(0, arr, resultNew);
        System.out.println(result);
    }

    private static void getPermutesWithoutExtraDS(int index, int[] arr, List<List<Integer>> result) {
        if (index == arr.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i : arr) {
                ds.add(i);
            }
            result.add(new ArrayList<>(ds));
        }


        for (int i = index; i < arr.length; i++) {
            swap(i, index, arr); // i and index are same here, frist case where replace it to self
            getPermutesWithoutExtraDS(index + 1, arr, result);
            swap(i, index, arr);

        }
    }

    private static void swap(int i, int j, int[] arr) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    private static void getPermutes(int[] arr, boolean[] marker, List<Integer> ds, List<List<Integer>> result) {

        if (ds.size() == arr.length) {
            result.add(new ArrayList<>(ds));
            return;
        }

        //pick i=0 means pickeing first elemnt then find out all the posiblity with picking 1 as first value
        // do same for all.
        // keep a boolean array for marking that which element we have visited and which not
        // this is a mehtod, we can improve this by removing extra space
        for (int i = 0; i < arr.length; i++) {

            if (!marker[i]) {
                marker[i] = true;
                ds.add(arr[i]);
                getPermutes(arr, marker, ds, result);
                //backtracking when we are going after returning
                ds.remove(ds.size() - 1);
                marker[i] = false;
            }

        }

    }
}
