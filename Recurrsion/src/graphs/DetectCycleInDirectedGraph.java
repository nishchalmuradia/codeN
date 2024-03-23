package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        int n = 10;

        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(3));
        adj.add(Arrays.asList(4, 7));
        adj.add(Arrays.asList(5));
        adj.add(Arrays.asList(6));
        adj.add(Arrays.asList());
        adj.add(Arrays.asList(5));
        adj.add(Arrays.asList(9));
        adj.add(Arrays.asList(10));
        adj.add(Arrays.asList(8));

        boolean isCycle = isCyclic(adj, n);
        System.out.println(isCycle);
    }

    private static boolean isCyclic(List<List<Integer>> adj, int n) {

        int[] vis = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            vis[i] = 0;
            path[i] = 0;
        }

        // we are using loop here as the grpagh can have multiple  non connected compoenent / connected as its directed
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                if (cycleCheckViaDFS(i, adj, vis, path)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean cycleCheckViaDFS(int index, List<List<Integer>> adj, int[] vis, int[] path) {
        vis[index] = 1;
        path[index] = 1;
        for (int it : adj.get(index)) {
            if (vis[it] == 0) {
                if (cycleCheckViaDFS(it, adj, vis, path))return true;
            } else if (path[it] == 1) {
                return true;
                // bcz it is visited but also the path is visited means it is involving in  the cyclce
                // if it was not the cycle then it should be 0 as in the return path we are marlking
                // path to 0 when no cycle
            }
            // coming here only if no cycle is there
            //no cycle is there means this path par no cycle
            // revert the path and mark it 0 again

        }
        // putting it here as in the loop it is not marking 1 , maring outside the loop only as recurrsive call
        path[index] = 0;

        return false;
    }
}
