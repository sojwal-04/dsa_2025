package sheet.arrays;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };


        int maxAreaOfIsland = solution.maxAreaOfIsland(grid);

        System.out.println("Max Area of Island is " + maxAreaOfIsland);
    }


    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        int maxArea = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] || grid[i][j] == 0) continue;
                // int newArea = dfs(grid, i, j, vis);
                int newArea = bfs(grid, i, j, vis);

                maxArea = Math.max(maxArea, newArea);
            }
        }

        return maxArea;
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int bfs(int[][] grid, int r, int c, boolean[][] vis){
        int area = 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        vis[r][c] = true;

        while(!q.isEmpty()){
            area++;

            int[] position = q.poll();

            int currRow = position[0], currCol = position[1];



            for(int[] direction: directions){

                int newRow = currRow + direction[0], newCol = currCol + direction[1];

                if(newRow< 0 || newCol < 0 || newRow>= m || newCol >= n
                        || grid[newRow][newCol] != 1 || vis[newRow][newCol])
                {
                    continue;
                }

                q.offer(new int[]{newRow, newCol});
                vis[newRow][newCol] = true;
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] vis){

        int m = grid.length, n = grid[0].length;
        if(r < 0 || c < 0 || r >= m || c >= n
                || grid[r][c] != 1 || vis[r][c]) return 0;


        vis[r][c] = true;

        int area = 1;

        for(int[] direction: directions){
            area += dfs(grid, r + direction[0], c + direction[1], vis);
        }
        // System.out.print("Area is = " + area);
        return area;
    }
}
