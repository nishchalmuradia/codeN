package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(Arrays.asList());
        adj.add(Arrays.asList(3));
        adj.add(Arrays.asList(1));
        adj.add(Arrays.asList(0, 1));
        adj.add(Arrays.asList(0, 2));

        Stack<Integer> resultSc = topologicalSort(adj);

        for(int i=0; i< adj.size(); i++){
            result.add(resultSc.peek());
            resultSc.pop();
        }
        System.out.println(result);
    }

    private static Stack<Integer> topologicalSort(List<List<Integer>> adj) {

        int vis[] = new int[adj.size()];
        Stack<Integer> sc = new Stack();
        for (int i = 0; i < vis.length; i++) {
            vis[i] = 0;
        }

        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == 0) {
                modifiedDFS(i, adj, vis, sc);
            }
        }
        return sc;
    }

    private static void modifiedDFS(int index, List<List<Integer>> adj, int[] vis, Stack sc) {
        vis[index] = 1;

        for (int it : adj.get(index)) {
            if (vis[it] == 0) {
                modifiedDFS(it, adj, vis, sc);
            }
        }
        sc.push(index);
    }
}
