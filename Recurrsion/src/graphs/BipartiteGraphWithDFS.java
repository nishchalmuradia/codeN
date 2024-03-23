package graphs;

import java.util.ArrayList;
import java.util.List;

public class BipartiteGraphWithDFS {

    public static void main(String[] args) {

    }
    public boolean isBipartite(int[][] graph) {
        // graph is here adj metric
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        for (int[] row : graph) {
            List<Integer> rowList = new ArrayList<>();
            for (int value : row) {
                rowList.add(value);
            }
            adj.add(rowList);
        }
        int vis[] = new int[adj.size()];
        for(int i=0; i<vis.length;i++){
            vis[i]=-1;
        }
        return isBipartiteGraph(1, adj, adj.size()-1, vis, 0);
    }



    private static boolean isBipartiteGraph(int node, List<List<Integer>> adj, int n, int[] vis, int color) {
        vis[node]=color;

        for(int it: adj.get(node)){
            if(vis[it] ==-1 ){
                return isBipartiteGraph(it, adj, n, vis, 1-color);
            }
            if(vis[it]==color){
                return false;
            }
        }
        return true;
    }
}