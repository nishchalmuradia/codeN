package graphs;

import javafx.util.Pair;

import java.lang.reflect.Parameter;
import java.util.*;

public class CycleInAGrapghByDFS {


    public static void main(String[] args) {
        int n = 7;

        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(Arrays.asList(2, 3));
        adj.add(Arrays.asList(1, 5));
        adj.add(Arrays.asList(1, 4, 6));
        adj.add(Arrays.asList(3));
        adj.add(Arrays.asList(2, 7));
        adj.add(Arrays.asList(3, 7));
        adj.add(Arrays.asList(5, 6));

        boolean isCyclic = isCyclicGraphByDFS(adj, n);
        System.out.println(isCyclic);
    }

    private static boolean isCyclicGraphByDFS(List<List<Integer>> adj, int n) {

        int[] vis = new int[n + 1];

        // putting 0 in whole array in start
        for (int i = 0; i < vis.length; i++) {
            vis[i] = 0;
        }
        vis[1] = 1;

        // it may be possible that grapgh have many component so do it for all

        for (int i = 1; i < n + 1; i++) {
            if (vis[i] == 0) {
                if (isCyclic(1, -1, adj, vis, n)) return true;
            }
        }
        return false;
    }

    private static boolean isCyclic(int index, int parent, List<List<Integer>> adj, int[] vis, int n) {

        vis[index] = 1;

        // go for all adj nodes
        for (int it : adj.get(index)) {
            if (vis[it] == 0) {
                if (isCyclic(it, index, adj, vis, n)) ;
            } else if (it != parent) {
                return true;
            }

        }
        return false;

    }
}
