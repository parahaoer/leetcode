package Queue;

import java.util.*;

class NumberofIslands5 {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;

    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          ++num_islands;
          grid[r][c] = '0'; // mark as visited
          Queue<Integer> visited = new LinkedList<>();
          //  只能使用r * nc + c , 不能使用r * nr + c;如果使用二维矩阵的行数做为系数，会越界。要用列数做系数
          visited.add(r * nc + c);
          while (!visited.isEmpty()) {
            int id = visited.remove();
            int row = id / nc;
            int col = id % nc;
            if (row - 1 >= 0 && grid[row-1][col] == '1') {
              visited.add((row-1) * nc + col);
              grid[row-1][col] = '0';
            }
            if (row + 1 < nr && grid[row+1][col] == '1') {
              visited.add((row+1) * nc + col);
              grid[row+1][col] = '0';
            }
            if (col - 1 >= 0 && grid[row][col-1] == '1') {
              visited.add(row * nc + col-1);
              grid[row][col-1] = '0';
            }
            if (col + 1 < nc && grid[row][col+1] == '1') {
              visited.add(row * nc + col+1);
              grid[row][col+1] = '0';
            }
          }
        }
      }
    }

    return num_islands;
  }

  public static void main(String[] args) {
    NumberofIslands4 numberofIslands = new NumberofIslands4();
    char[][] chars = {{'1','1'},{'0','0'}, {'1', '1'}, {'0', '0'}};
    NumberofIslands5 numberofIslands5 = new NumberofIslands5();
    int res = numberofIslands5.numIslands(chars);
    System.out.println(res);
  }
}