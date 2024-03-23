package graphs;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] grid = {{'0', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', 'X', '0', 'X'},
                {'X', '0', 'X', 'X'}};
        char[][] result = getsurroundedRegions(grid);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }

    }

    private static char[][] getsurroundedRegions(char[][] grid) {
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

        // we are using extended DFS here
        //call bfs for all the 0's of the boundary

        // traverse first row and last row
        for (int j = 0; j < m; j++) {

            //first row
            if (vis[0][j] == 0 && grid[0][j] == '0') {
                bfs(0, j, vis, grid, delRow, delCol);
            }

            //last row
            if (vis[n - 1][j] == 0 && grid[n - 1][j] == '0') {
                bfs(n - 1, j, vis, grid, delRow, delCol);
            }
        }

        //traverse first and last colum excluding corners as visited before while traversing the rows
        for (int i = 1; i < n; i++) {

            //first column
            if (vis[i][0] == 0 && grid[i][0] == '0') {
                bfs(i, 0, vis, grid, delRow, delCol);
            }

            //last row
            if (vis[i][m - 1] == 0 && grid[i][m - 1] == '0') {
                bfs(i, m - 1, vis, grid, delRow, delCol);
            }
        }


        // now put X where tjhe boundery meets and and check the visted array

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if visited means that is not need to include
                if (vis[i][j] == 0 && grid[i][j] == '0') {
                    grid[i][j] = 'X';
                }
            }
        }
        return grid;
    }

    private static void bfs(int row, int col, int[][] vis, char[][] grid, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && grid[nRow][nCol] == '0') {
                bfs(nRow, nCol, vis, grid, delRow, delCol);
            }
        }
    }


}

