package graphs;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,1,1},
                {1,1,0,1,0}};
        int numberOdEnc = numberOdDistinctIslands(grid);
        System.out.println(numberOdEnc);

    }

    private static int numberOdDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        Set<List<Pair<Integer, Integer>>> distSet = new HashSet<>();

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int vis[][] = new int[n][m];
        for(int i=0; i<n;i++){
            for(int j =0; j<m; j++){
                vis[i][j]=0;
            }
        }

        for(int i=0 ;i<n;i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    List<Pair<Integer, Integer>> list = new ArrayList<>();
                    dfs(i, j, grid, vis,delCol, delRow ,list, i, j);
                    distSet.add(list);
                }
            }
        }

        //Distinct logic here
        return distSet.size();
    }

    private static void dfs(int row, int col, int[][] grid, int[][] vis, int[] delCol, int[] delRow,
                            List<Pair<Integer, Integer>> list,int row0, int col0) {
        vis[row][col]=1;
        list.add(new Pair<>(row-row0,col-col0));

        for (int i = 0; i < 4; i++) {// 4 loop for 4 direction
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, grid, vis, delCol, delRow, list, row0, col0);
            }
        }

    }


}
