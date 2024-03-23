package graphs;

public class NumberOfEnclaves {

    //You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
    //A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off
    // the boundary of the grid.
    //Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
//https://leetcode.com/problems/number-of-enclaves/description/
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};
        int numberOdEnc = numberOfEnclaves(grid);
        System.out.println(numberOdEnc);

    }

    private static int numberOfEnclaves(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = 0;
            }
        }
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // WE NEED TO CHECK BOUNDARY CONDITIONS FIRST.

        //first and last column


        for (int i = 0; i < n; i++) {
            //first col
            if (grid[i][0] == 1 && vis[i][0] ==0) {
                dfs(i, 0, grid, vis, delCol, delRow, n, m);
            }

            //last col
            if (grid[i][m - 1] == 1 && vis[i][m-1] ==0) {
                dfs(i, m - 1, grid, vis, delCol, delRow, n, m);
            }
        }


        for (int j = 1; j < m - 1; j++) {

            //first row
            if (grid[0][j] == 1 && vis[0][j] ==0) {
                dfs(0, j, grid, vis, delCol, delRow, n, m);
            }

            //last col
            if (grid[n - 1][j] == 1 && vis[n-1][j] ==0 ) {
                dfs(n - 1, j, grid, vis, delCol, delRow, n, m);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;

    }


    private static void dfs(int row, int col, int[][] grid, int[][] vis, int[] delCol, int[] delRow, int n, int m) {
        vis[row][col] = 1;

        for (int i = 0; i < 4; i++) {// 4 loop for 4 direction
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, grid, vis, delCol, delRow, n, m);
            }
        }
    }

}
