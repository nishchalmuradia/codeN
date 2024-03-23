package leetcodedaily.recurrsion;

public class ReverseAnArray {


    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] result = reverseArray(arr);
        for (int i : result) {
            System.out.println(i);
        }

    }

    private static int[] reverseArray(int[] arr) {

        int l = 0;
        int r = arr.length - 1;
        //return swapUsing2Pointer(l, r, arr);
        return swapUsingOnePointer(l, arr.length, arr);

    }

    private static int[] swapUsing2Pointer(int l, int r, int[] arr) {
        if (l >= r) {
            return arr;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return swapUsing2Pointer(l + 1, r - 1, arr);
    }

    private static int[] swapUsingOnePointer(int l, int n, int[] arr) {
        if (l >= arr.length / 2) {
            return arr;
        }
        swap(l, n, arr);
        return swapUsingOnePointer(l + 1, n, arr);
    }

    private static void swap(int l, int n, int[] arr) {
        int temp = arr[l];
        arr[l] = arr[n - l - 1];
        arr[n - l - 1] = temp;
    }
}
