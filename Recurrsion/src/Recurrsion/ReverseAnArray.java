package Recurrsion;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ReverseAnArray {

    //using 2 pointer recurrsion

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
       revArray(arr);
        for(int i : arr){
            System.out.println(i);
        }

    }

    private static void revArray(int[] arr) {
        swapUsing2Pointer(0, arr.length-1, arr);

    }

    private static void swapUsing2Pointer(int l, int r, int[] arr) {
        if(l>=r){
            return;
        }
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l]= temp;
        swapUsing2Pointer(l+1, r-1, arr);
    }
}
