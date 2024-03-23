package leetcodedaily.heap;

import java.util.PriorityQueue;

public class kthSmallestElementArray {
    public static int findKthsmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a); // max-heap

        for (int i = 0; i < nums.length; i++) {
            maxheap.add(nums[i]);
            if (maxheap.size() > k) {
                maxheap.poll();
            }
        }
        return maxheap.peek();
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthsmallest(a, 3));
    }
}
