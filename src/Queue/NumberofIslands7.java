package Queue;

import java.util.LinkedList;
import java.util.Queue;

class NumberofIslands7 {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int result = 0;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++) {
                if(grid[i][j] =='1' && visited[i][j]==false) {
                    result ++;
                    dfs(grid, visited, i, j);
                }
            }
        return result;
    }

    public void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        if(r>=0 && r <m && c>=0 && c<n && visited[r][c] == false && grid[r][c] == '1') {
            visited[r][c] = true;
            dfs(grid, visited, r-1, c);
            dfs(grid, visited, r+1, c);
            dfs(grid, visited, r, c-1);
            dfs(grid, visited, r, c+1);
        }
    }

}