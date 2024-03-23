package leetcodedaily.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargestElementInArray {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minheap.add(nums[i]);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        return minheap.peek();
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(a, 3));
    }
}
