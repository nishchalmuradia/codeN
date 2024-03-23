package leetcodedaily;

import java.util.*;

public class Solution {

    public static int maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        maxSum = Math.max(maxSum, currentSum);

        for (int j = k; j < nums.length; j++) {
            currentSum = currentSum - nums[j - k] + nums[j];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {100, 900, 300, 400};
        System.out.println(maxSlidingWindow(arr, 2));

    }
}
