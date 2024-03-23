package leetcodedaily.heap;

import javafx.util.Pair;

import java.util.*;

public class FindKClosestNumber {

    public static void main(String[] args) {
        int[] a ={1,2,3,4,5};
        int k = 4;
        int x = 3;
        List<Integer> kClosestNumber = findClosestElements(a, k, x);

        System.out.println(kClosestNumber);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Pair<Integer, Integer>> maxheap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

        for (int i = 0; i < arr.length; i++) {
            maxheap.add(new Pair<>(Math.abs(x - arr[i]), arr[i]));
            if (maxheap.size() > k) {
                maxheap.poll();
            }
        }
        while (!maxheap.isEmpty()) {
            result.add(maxheap.peek().getValue());
            maxheap.poll();
        }
        Collections.sort(result);
        return result;
    }
}
