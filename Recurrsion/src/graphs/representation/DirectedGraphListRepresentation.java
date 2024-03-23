package graphs.representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectedGraphListRepresentation {

    // space complexity = e;  (not 2e, just e bcz sving one time only )

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
        }

        System.out.println(adj);
    }
}
