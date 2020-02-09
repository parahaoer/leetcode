package Array;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if(n==0) return new ArrayList();
        int m = matrix[0].length;
        List<Integer> res = new ArrayList();
        int r=0;
        int c=0;
        int di=0;
        boolean[][] visited = new boolean[n][m];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i=0; i<n*m; i++) {
            //System.out.println(matrix[r][c]);
            res.add(matrix[r][c]);
            visited[r][c] = true;

            int rc = r + dirs[di][0];
            int cc = c + dirs[di][1];
            System.out.println(cc);
            //visited[rc][cc]不能放在最前面，可能会越界
            if(rc<n && rc>=0 && cc<m && cc>=0 && visited[rc][cc] == false) {
                r = rc;
                c = cc;
                //System.out.println(c);
            } else {
                System.out.println(c);
                di = (di+1) %4;
                r = r + dirs[di][0];
                c = c + dirs[di][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralOrder(matrix);
    }

}
