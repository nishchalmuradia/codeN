package Recurrsion;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 2, 5, 7, 9, 1, 3};

        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition_index = findPartitionIndex(arr, low, high);
            quickSort(arr, low, partition_index - 1);
            quickSort(arr, partition_index + 1, high);
        }
    }

    private static int findPartitionIndex(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            // while one place <= and why at another > only, bcz if we have duplicate values then it make sense

            if (i < j) {
                //swapping
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // now swap j with pivot
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        return j;
    }

}
