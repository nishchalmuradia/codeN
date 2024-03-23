package graphs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };

        System.out.println(numberOfIsland(grid));
    }

    private static int numberOfIsland(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));

        // starting a copy array for visited , and putting all 0s in this
        int[][] visited = new int[grid.length][grid.length + 1];

        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    islandCount++;
                    modifiedBFS(i, j, visited, grid, queue);
                }
            }
        }
        return islandCount;
    }

    private static void modifiedBFS(int i, int j, int[][] visited, int[][] grid, Queue<Pair<Integer, Integer>> queue) {

        visited[i][j] = 1;

        while (!queue.isEmpty()) {

            //remove top of queue
            Pair<Integer, Integer> peek = queue.peek();
            queue.remove();

            //add all the adj (modified all 8 direction to the queue) as need to traverse the neighbours
            // instead of add all 8 conditions , use the trick
            int row = peek.getKey();
            int col = peek.getValue();

            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nRow = row + delrow;//neighbourRow
                    int ncol = col + delcol;//neighbourCOl
                    if (nRow >= 0 && nRow < grid.length
                            && ncol >= 0 && ncol < grid[0].length
                            && grid[nRow][ncol] == 1 && visited[nRow][ncol] == 0) {
                        visited[nRow][ncol] = 1;
                        queue.add(new Pair<>(nRow, ncol));
                    }
                }
            }

        }
    }
}
