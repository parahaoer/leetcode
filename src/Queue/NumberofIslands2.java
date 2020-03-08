package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j]==false) {
                    visited = bfs(grid, i, j, visited);
                    res++;
                }
            }
        }

        return res;
    }

    private boolean[][] bfs(char[][] grid, int i, int j, boolean[][] visited) {
        //方向
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        //坐标
        int[] coor = {i, j};
        q.offer(coor);
        while (!q.isEmpty()) {
            //cur表示当前的点的坐标
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            for (int k = 0; k < 4; k++) {
                int tx = cur[0] + dx[k];
                int ty = cur[1] + dy[k];
                if (tx < 0 || tx >= grid.length || ty < 0 || ty >= grid[0].length || grid[tx][ty] == '0' || visited[tx][ty] == true) {
                    continue;
                }
                int[] neighbor = {tx, ty};
                q.offer(neighbor);
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        NumberofIslands2 numberofIslands = new NumberofIslands2();
        char[][] chars = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int res = numberofIslands.numIslands(chars);
        System.out.println(res);
    }
}
