package graphs;

import javafx.util.Pair;

import java.util.*;

public class BipartiteGraph {
// if we can color the grapgh with 2 color where no adj node have the same color then irt is bipartite for sure

    public static void main(String[] args) {
        int n =8;
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(1, 3,6));
        adj.add(Arrays.asList(2, 4));
        adj.add(Arrays.asList(3, 5, 7));
        adj.add(Arrays.asList(4, 6));
        adj.add(Arrays.asList(2, 5));
        adj.add(Arrays.asList(4, 8));
        adj.add(Arrays.asList(7));
        boolean isBipartiteGraph = isBipartiteGraph(adj, n);
        System.out.println(isBipartiteGraph);

    }

    private static boolean isBipartiteGraph(List<List<Integer>> adj, int n) {
        // we have 2 colors here, 0 and 1
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int[] vis = new int[n + 1];

        // marking all the array with -1
        for (int i = 1; i < vis.length; i++) {
            vis[i] = -1;
        }
        vis[1] = 0;

        while (!queue.isEmpty()) {
            int peek = queue.peek();
            queue.remove();

            for (int i : adj.get(peek)) {
                // if the adjacent node is yet not colored
                // you will give the opposite color of the node
                if (vis[i] == -1) {
                    vis[i] = 1 - vis[peek];
                    queue.add(i);
                } else if (vis[i] == vis[peek]) {
                    return false;
                }
            }

        }

        return true;
    }
}
