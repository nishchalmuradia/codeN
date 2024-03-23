package graphs;

import java.util.*;

public class KahnsAlgorithmTopologicalSortBFS {

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(Arrays.asList());
        adj.add(Arrays.asList(3));
        adj.add(Arrays.asList(1));
        adj.add(Arrays.asList(0, 1));
        adj.add(Arrays.asList(0, 2));
        int n = adj.size();

        int[] inDegree = new int[adj.size()];
        for (int i = 0; i < inDegree.length; i++) {
            inDegree[i] = 0;
        }

        for (int i = 0; i < adj.size(); i++) {
            for (int j : adj.get(i)) {
                inDegree[j]++;
            }
        }
        List<Integer> topoResult = topologicalSort(n, adj, inDegree);
        System.out.println(topoResult);

    }

    private static List<Integer> topologicalSort(int n, List<List<Integer>> adj, int[] inDegree) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        // first add all of them where have 0 indegree
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            topo.add(node);

            // node is in your topo sort
            // so please remove it from the indegree
            for (int it : adj.get(node)) {
                inDegree[it]--;
                // if indegree becomes 0 then just add it to the queue so we can proceed further
                if (inDegree[it] == 0) {
                    queue.add(it);
                }
            }

        }
        return topo;
    }
}
