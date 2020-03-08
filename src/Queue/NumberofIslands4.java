package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands4 {
    public int numIslands(char[][] grid) {
        int m =grid.length, n= grid[0].length;
        if (grid == null || m == 0 || n == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int res = 0;
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j]==false) {
                    res++;
                    Queue<Integer> queue = new LinkedList();

                    queue.offer(i*n+j);
                    while (!queue.isEmpty()) {
                        int t = queue.poll();
//                        visited[coor[0]][coor[1]] = true;
                        for (int k = 0; k < 4; k++) {
                            int cx = t/n + dx[k];
                            int cy = t%n + dy[k];
                            if (cx < 0 || cx >= m || cy < 0 || cy >= n || grid[cx][cy] == '0' || visited[cx][cy] == true)
                                continue;
                            visited[cx][cy] =true;
                            queue.offer(cx *n + cy);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberofIslands4 numberofIslands = new NumberofIslands4();
        char[][] chars = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int res = numberofIslands.numIslands(chars);
        System.out.println(res);
    }
}
