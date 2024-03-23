package leetcodedaily.slidingWindow;

import java.util.*;

public class FirstNegNoInKsizeWindow {

    public static void firstNegative(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> negativeIndices = new LinkedList<>();

        int i = 0;
        int j = 0;

        while (j < nums.length) {

            // Here we are just adding the negative indices of the elements so that we dont want to calclulate again and agian
            if (nums[j] < 0) {
                negativeIndices.offer(j);
            }

            if (j - i + 1 < k) {
                // finding the window only. till that do j++
                j++;
            } else if (j - i + 1 == k) {
                // if window size is correct and then check negativeIndices is not empty and the first element of this
                // (obv index) is is should less then the i to delete maro ise
                if (!negativeIndices.isEmpty() && negativeIndices.peek() < i) {
                    negativeIndices.poll();
                }

                if (negativeIndices.isEmpty()) { //means start m is window m koi bhi -ve element nhi tha
                    result.add(0);
                } else {
                    result.add(nums[negativeIndices.peek()]); // add the peak of the queue index's element
                }

                i++;//increse i and j
                j++;
            }
        }

        System.out.println("First negative integers in every window of size " + k + ": " + result);
    }

    public static void main(String[] args) {
        int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;

        firstNegative(nums, k);
    }
}
