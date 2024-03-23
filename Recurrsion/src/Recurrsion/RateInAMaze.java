package Recurrsion;

import java.util.ArrayList;
import java.util.List;

public class RateInAMaze {

    private static void solve(int i, int j, int arr[][], int n, List<String> ans, String move, int vis[][]) {

        //base condition
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        // we will check in lexicographical order (DLRU) so we will get ans in the same order

        // downwords
        //vis[i + 1][j] == 0  : check if it is already visited or not
        if (i + 1 < n && vis[i + 1][j] == 0 && arr[i + 1][j] == 1) {
            vis[i][j] = 1;
            solve(i + 1, j, arr, n, ans, move + 'D', vis);
            vis[i][j] = 0; // backtrack
        }

        // left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && arr[i][j - 1] == 1) {
            vis[i][j] = 1;
            solve(i, j - 1, arr, n, ans, move + 'L', vis);
            vis[i][j] = 0;
        }

        //right
        if (j + 1 < n && vis[i][j + 1] == 0 && arr[i][j + 1] == 1) {
            vis[i][j] = 1;
            solve(i, j + 1, arr, n, ans, move + 'R', vis);
            vis[i][j] = 0;
        }

        // up
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && arr[i - 1][j] == 1) {
            vis[i][j] = 1;
            solve(i - 1, j, arr, n, ans, move + 'D', vis);
            vis[i][j] = 0;
        }
    }


    private static List<String> findpath(int[][] arr, int n) {
        // new Array to create if we have visited or not
        int vis[][] = new int[n][n];

        // putting all 0 in new array so we can mark 1 for visit later
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }

        List<String> ans = new ArrayList<>();
        // first [0][0] must be 1 bcz its start point nad rat only go to one so obvious it will be 1, otehrwise no ans
        if (arr[0][0] == 1) {
            solve(0, 0, arr, n, ans, "", vis);
        }
        return ans;
    }

    public static void main(String[] args) {

        int n = 4;
        int[][] arr = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        List<String> result = findpath(arr, n);
        System.out.println(result);

    }

    //Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.
    //Space Complexity:  O(m*n), Maximum Depth of the recursion tree(auxiliary space).
}
