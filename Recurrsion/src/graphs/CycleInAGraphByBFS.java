package graphs;

import javafx.util.Pair;

import java.util.*;

public class CycleInAGraphByBFS {


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

        boolean isCyclic = isCyclicGraph(adj, n);
        System.out.println(isCyclic);
    }

    private static boolean isCyclicGraph(List<List<Integer>> adj, int totalNodes) {

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int n = adj.size();
        int[] vis = new int[totalNodes + 1];
        // marking all 0 in visited array
        for (int i = 0; i < totalNodes + 1; i++) {
            vis[i] = 0;
        }
        vis[1] = 1;


        queue.add(new Pair<>(1, -1));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> peek = queue.peek();
            int first = peek.getKey();
            int parent = peek.getValue();
            queue.remove();

            for (int it : adj.get(peek.getKey())) {
                if (vis[it] == 0) {
                    queue.add(new Pair<>(it, peek.getKey()));
                    vis[it] = 1;
                }
                // if adjacent node is visited and is not its own parent node
                // parent means the parent of current node u r visited , value of ur Pair
                else if (parent != it) {
                    return true;
                }
            }
        }
        return false;

    }
}
