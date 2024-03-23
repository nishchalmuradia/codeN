package learn;

public class ArrayOperations {

    public static void main(String[] args) {

        int[] arr = {10, 11, 12, 13, 14};

        //printArray(arr);

        //findANumberInArray(arr, 139);

        //int index = findANumberInArrayByReturn(arr, 13);

        //reverse an array
        //reverseArray(arr);

        // reverseArrayWithoutExtraArrayAnd2Pointer(arr);

        int[] array2 = new int[3];
        array2[0] = 10;
        array2[1] = 100;

        int sizeAfterInsertion = arrayInsertion(array2, 1100, 2, 2);

        //printArray(array2);

        int sizeAfterDeletion = deleteElenntInArray(array2, 10, 3);
        for(int i=0; i<sizeAfterDeletion; i++){
            System.out.println(array2[i]);
        }


    }

    private static int deleteElenntInArray(int[] array2, int num, int size) {

        int indexofNum = findANumberInArrayByReturn(array2, num);
        
        for(int i = indexofNum; i<array2.length-1;i++){
            array2[i] = array2[i+1];
        }
        return --size;

    }



    private static int arrayInsertion(int[] array2, int num, int index, int size) {
        if (size < array2.length) {
            array2[index] = num;
            return size + 1;
        }
        return size;
    }

    private static void reverseArrayWithoutExtraArrayAnd2Pointer(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int temp;
        while (start < end) {
            temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void reverseArray(int[] arr) {
        int[] reverseArray = new int[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--, j++) {
            reverseArray[j] = arr[i];
            System.out.println(reverseArray[j]);
        }

    }


    private static int findANumberInArrayByReturn(int arr[], int num) {

        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return i;
            }
        }
        return -1;

    }


    private static void findANumberInArray(int arr[], int num) {

        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                System.out.println("Number found at index" + i);
                return;
            }
        }
        System.out.println("Number not found");

    }


    private static void printArray(int [] arr) {
        //array creation


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
