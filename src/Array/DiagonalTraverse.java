package Array;

import java.util.*;
/*
* Spiral Matrix的方法是计算坐标的候选值，这是因为它在边界的转折点是有规律的（按顺时针方向）。
* 而本题在边界转折到下一个点是没有规律的。虽然要么向下，要么向右。但是可能连续向右，或者连续向下，并没有规律
* 本题的规律正是从不同的越界点有不同的移动位置。
* */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> list = new ArrayList();

        int d = 0;
        int[][] dirs = new int[][]{{-1, 1}, {1, -1}};

        int i=0, j=0;

        for(int k = 0; k < m*n; k++) {

                list.add(matrix[i][j]);
                i += dirs[d][0];
                j += dirs[d][1];
            //需要把超过上边界的判断放在前面，因为可能同时出现i=m,j=-1这种情况。这时优先使用i=m时的处理方法
            if(i>=m) {
                i = m -1;
                j = j+2;
                d = 1-d;
            }
            if(j>=n) {
                j = n-1;
                i = i +2;
                d = 1-d;
            }
            if(j<0) {
                j=0;
                d = 1-d;
            }

            if(i <0) {
                i = 0;
                d = 1-d;
            }

            }

        int[] res = new int[list.size()];
        for(int k=0; k<list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        int[] res = diagonalTraverse.findDiagonalOrder(nums);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
