package graphs;


import java.util.LinkedList;
import java.util.Queue;

class Pairs {
    int i;
    int j;
    int step;

    public Pairs(int i, int j, int step) {
        this.i = i;
        this.j = j;
        this.step = step;
    }
}

public class DistanceOfNearestCellHaving1 {

    public static void main(String[] args) {
        int[][] input = {
                {0, 0, 0},
                {0, 0, 0},
                {1, 0, 0}
        };

        int[][] output = distanceCalculate(input);
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] distanceCalculate(int[][] grid) {
        Queue<Pairs> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Pairs(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    // mark unvisited
                    vis[i][j] = 0;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int row = queue.peek().i;
            int col = queue.peek().j;
            int steps = queue.peek().step;
            queue.remove();

            if (grid[row][col] == 1) {
                dist[row][col] = 1;
            } else {
                dist[row][col] = steps;
            }


            //all four neightbour

            for (int p = 0; p < 4; p++) {
                int nRow = row + delRow[p];
                int nCol = col + delCol[p];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0) {
                    vis[nRow][nCol] = 1;
                    queue.add(new Pairs(nRow, nCol, steps + 1));
                }
            }
        }
        return dist;

    }

}
