package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands3 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j]==false) {
                    res++;
                    Queue<int[]> queue = new LinkedList();
                    int[] coor = {i, j};
                    queue.offer(coor);
                    while (!queue.isEmpty()) {
                        coor = queue.poll();
                        visited[coor[0]][coor[1]] = true;
                        for (int k = 0; k < 4; k++) {
                            int cx = coor[0] + dx[k];
                            int cy = coor[1] + dy[k];
                            if (cx < 0 || cx > grid.length || cy < 0 || cy > grid[0].length || grid[cx][cy] == '0' || visited[cx][cy] == true)
                                continue;
                            int[] neighbers = {cx, cy};
                            queue.offer(neighbers);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberofIslands3 numberofIslands = new NumberofIslands3();
        char[][] chars = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int res = numberofIslands.numIslands(chars);
        System.out.println(res);
    }
}
