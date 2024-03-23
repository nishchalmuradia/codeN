import java.util.Scanner;

public class GraphMetricRepresentation {


    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        int[][] adj = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            Scanner sc = new Scanner(System.in);
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        System.out.println(adj);
    }
}
