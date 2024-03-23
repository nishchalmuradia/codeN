package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindEventualSafeStates {

    public static void main(String[] args) {
        int n = 12;

        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(1));
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(3));
        adj.add(Arrays.asList(4, 5));
        adj.add(Arrays.asList(6));
        adj.add(Arrays.asList(6));
        adj.add(Arrays.asList(7));
        adj.add(Arrays.asList());
        adj.add(Arrays.asList(1, 9));
        adj.add(Arrays.asList(10));
        adj.add(Arrays.asList(8));
        adj.add(Arrays.asList());


        List<Integer> safeNodes = checkForSafeStates(adj, n);
        Collections.sort(safeNodes);
        System.out.println(safeNodes);

    }

    private static List<Integer> checkForSafeStates(List<List<Integer>> adj, int n) {
        int[] vis = new int[n];

        int[] path = new int[n];

        for (int i = 0; i < n; i++) {
            vis[i] = 0;
            path[i] = 0;
        }
        List<Integer> safeStateList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                checkCycleAndSafeStateByDFS(i, adj, n, vis, path, safeStateList);
            }
        }
        return safeStateList;
    }

    private static boolean checkCycleAndSafeStateByDFS(int index, List<List<Integer>> adj, int n, int[] vis, int[] path,
                                                       List<Integer> safeStateList) {

        vis[index] = 1;
        path[index] = 1;
        for (int it : adj.get(index)) {
            if (vis[it] == 0) {
                if (checkCycleAndSafeStateByDFS(it, adj, n, vis, path, safeStateList)) {
                    //cycle check and got the cycle thats why return the true
                    return true;
                }
            } else if (path[it] == 1) {
                return true;
            }
        }
        path[index] = 0;
        safeStateList.add(index);
        return false;// means no cycle
    }
}
