package leetcodedaily.heap;

import javafx.util.Pair;

import java.util.*;

public class TopKfrequentElement {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 3, 2, 2, 4};
        int k = 2;

        int[] ints = topKfrequentElement(a, k);
        for(int arrayelement: ints) {
            System.out.println(arrayelement);
        }
    }

    private static int[] topKfrequentElement(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Pair<Integer, Integer>> minHeap =new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                minHeap.add(new Pair<>( entry.getValue(),entry.getKey() ));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getValue());
        }
        Collections.reverse(result);
        int [] res= new int[k];
        for(int i=0; i<result.size();i++){
            res[i] = result.get(i);
        }

        return res;
    }
}
