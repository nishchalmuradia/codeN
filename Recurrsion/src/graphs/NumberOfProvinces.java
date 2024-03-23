package graphs;

import java.util.*;

public class NumberOfProvinces {


    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(1));
        adj.add(Arrays.asList());

        int visited[] = new int[adj.size()];
        for (int i : visited) {
            visited[i] = 0;
        }
        System.out.println(getNumberOfProvinces(adj, visited    ));

    }

    private static int getNumberOfProvinces(List<List<Integer>> adj, int[] visited) {

        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, adj, visited);
            }
        }
    return count;
    }

    private static void dfs(int node, List<List<Integer>> adj, int[] visited) {
        visited[node] = 1;

        for (int adjItem : adj.get(node)) {
            if (visited[adjItem] == 0) {
                dfs(adjItem, adj, visited);
            }
        }
    }


}
