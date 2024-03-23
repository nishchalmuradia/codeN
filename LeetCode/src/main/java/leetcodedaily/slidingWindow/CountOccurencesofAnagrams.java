package leetcodedaily.slidingWindow;

public class CountOccurencesofAnagrams {

    public static int getlargest(int[] arr) {
        int largest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 445, 56};
        int getlargest = getlargest(arr);
        System.out.println(getlargest);
    }
}



