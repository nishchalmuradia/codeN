package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 4, 1, 5, 2, 6, 4};

        merge_sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i+", ");
        }
    }

    private static void merge_sort(int[] arr, int low, int high) {

        if (low == high) return; //base condition
        int mid = (low + high) / 2;

        merge_sort(arr, low, mid);
        merge_sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low; // start point of the orst imaginary array
        int right = mid + 1; // start po0int of the 2nd imaginary array

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        // even if after all these , if the left array have elements then add all
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // even if after all these , if the right array have elements then add all
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // now all the elements are in the arraylist, wre have to move them into the existing array.
        // dont freak out that how we are gonna save them in array if the places will be diff, that part is sorted, think larger

        for(int i=low; i<=high; i++){
            // low to high and then we need to put them in their right places so need to take help of low here
            // serial wise , we started from low so start putting them back from low index
            arr[i]= temp.get(i-low);
        }
    }
}
