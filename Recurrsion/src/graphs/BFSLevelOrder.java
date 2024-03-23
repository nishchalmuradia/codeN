package graphs;

import java.util.*;

public class BFSLevelOrder {

    public static void main(String[] args) {
        int n = 9;
        int m = 9;
        //List<List<Integer>> adj = getRepresentation(n, m);
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(Arrays.asList(2,6));
        adj.add(Arrays.asList(1,3,4));
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(2,5));
        adj.add(Arrays.asList(4,8));
        adj.add(Arrays.asList(1,7,9));
        adj.add(Arrays.asList(6,8));
        adj.add(Arrays.asList(5,7));
        adj.add(Arrays.asList(6));

        bfs(n, m, adj);
    }

    private static void bfs(int n, int m, List<List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            // check if the node is already visited and traversed
            if (visited.contains(queue.peek())) {
                continue;
            }

            //i from the queue and mark it treversed and print
            int peak = queue.peek();
            System.out.print(peak+ " ");
            visited.add(peak);
            queue.remove(peak);

            //add all the adj of removed element to the queue
            for (int a : adj.get(peak)) {
                if(!visited.contains(a)){
                    queue.add(a);
                }
            }
            //add all the element sto queue(neighabor of your i element)

        }
    }

    private static List<List<Integer>> getRepresentation(int n, int m) {

        //just doing the initialisation
        List<List<Integer>> ds = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            ds.add(new ArrayList<>());
        }


        //undirecetd grapgh
        for (int i = 0; i < m; i++) {
            Scanner sc = new Scanner(System.in);
            int u = sc.nextInt();
            int v = sc.nextInt();
            ds.get(u).add(v);
            ds.get(v).add(u);
        }
        return ds;
    }
}
