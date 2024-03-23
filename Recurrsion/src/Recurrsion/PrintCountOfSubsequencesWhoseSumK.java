package Recurrsion;

public class PrintCountOfSubsequencesWhoseSumK {
    //print all subsequence whose sum is 2
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int sum = 0;
        int k = 2;
        System.out.println(printSubWithKSum(0, sum, arr, k));
    }

    private static int printSubWithKSum(int index, int sum, int[] arr, int k) {

        //base conditon (satidfy then send 1 (means match found) then add wiht this one to the other one if have.)
        //even no need to take the data structure (arraylist) as nothing we are printing
        if (index == arr.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }
        sum += arr[index];


        //pick case
        int left = printSubWithKSum(index + 1, sum, arr, k);
        sum -= arr[index];

        //unpick case
        int right = printSubWithKSum(index + 1, sum, arr, k);

        return left + right;
    }

}
