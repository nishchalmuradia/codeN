package graphs;

import java.util.*;

public class DFS {


    public static void main(String[] args) {
        int n = 9;
        int m = 9;
        //List<List<Integer>> adj = getRepresentation(n, m);
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(Arrays.asList(2,3));
        adj.add(Arrays.asList(1,5,6));
        adj.add(Arrays.asList(1,4,7));
        adj.add(Arrays.asList(3,8));
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(3,8));
        adj.add(Arrays.asList(4,7));

        Set<Integer> visited = new HashSet<>();
        dfs(1, adj, visited);
        //System.out.println(visited);

    }

    private static void dfs(int node, List<List<Integer>> adj, Set<Integer> visited) {

        visited.add(node);
        //System.out.print(node + " ");

        //loop all its adj and do dfs of each one
        for (Integer i : adj.get(node)) {
            if (!visited.contains(i)) {
                dfs(i, adj, visited);
            }
        }
    }
}
