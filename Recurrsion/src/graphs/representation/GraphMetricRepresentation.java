package graphs.representation;

import java.util.Scanner;

public class GraphMetricRepresentation {

//  Time complexity: (n)
    // space require: metric  n*n : n^2 space
    public static void main(String[] args) {
        int n = 5;// nodes
        int m = 6;//edges
        int[][] adj = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            Scanner sc = new Scanner(System.in);
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
