package graphs;

public class FloodFillAlgorithm {


    // need to check only 4 side up, down , right left

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 2;
        int sc = 0;
        int initial_color = 1;
        int newColor = 2;

        int[][] floodGrid = floodFillAlgo(grid, sr, sc, newColor, initial_color);
        for(int[] i: floodGrid){
            for(int p: i){
                System.out.print(p+ " ");
            }
            System.out.println();
        }
    }

    private static int[][] floodFillAlgo(int[][] grid, int sr, int sc, int newColor, int initial_color) {
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        modifiedDFS(sr, sc, grid, visited, newColor, initial_color, delrow, delcol);
        return grid;
    }

    private static void modifiedDFS(int sr, int sc, int[][] grid, boolean[][] visited, int newColor, int initial_color,
                                    int[] delrow, int[] delcol) {
        visited[sr][sc] = true;
        grid[sr][sc] = newColor;


        for (int i = 0; i < visited.length; i++) {
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length
                    && grid[nrow][ncol] == initial_color && visited[nrow][ncol] != true) {
                modifiedDFS(nrow, ncol, grid, visited, newColor, initial_color, delrow, delcol);

            }

        }
    }
}
