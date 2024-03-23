package leetcodedaily.heap;

import java.util.PriorityQueue;
import java.util.Vector;

public class SortANearlySortedArray {


    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(sortArray(a, 2));
    }

    private static Vector sortArray(int[] a, int k) {
        Vector<Integer> v = new Vector<>();
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int i=0;i <a.length;i++){
            minheap.add(a[i]);
                if(minheap.size()>k){
                    v.add(minheap.peek());
                    minheap.poll();
                }
        }
        while (minheap.peek() !=null){
            v.add(minheap.peek());
            minheap.poll();
        }
        return v;
    }


}
