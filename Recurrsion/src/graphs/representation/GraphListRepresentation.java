package graphs.representation;

import java.util.*;

public class GraphListRepresentation {

    // this if for undirected grapgh

    // for directed grapgh dont add the reverse.
//Time complexity :n
    // space complexity = 2*e;

    public static void main(String[] args) {
        int n = 5;// nodes
        int m = 6;//edges

        List<List<Integer>> adj = new ArrayList<>(n);

        //add empty list and initialize
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            Scanner sc = new Scanner(System.in);
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        System.out.println(adj);
    }
}
