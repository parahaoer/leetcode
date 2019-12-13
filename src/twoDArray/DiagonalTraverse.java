package twoDArray;

class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        //建立坐标系,r代表横坐标，c代表纵坐标，dirs表示移动的方向
        int m = matrix.length, n = matrix[0].length, r = 0, c = 0, k = 0;
        int[] res= new int[m*n];
        int[][] dirs = {{-1,1}, {1,-1}};
        for (int i = 0; i < m * n; ++i) {
            res[i] = matrix[r][c];
            r += dirs[k][0];
            c += dirs[k][1];
            //如果row超过了m-1的范围，那么row重置为m-1，并且col自增2，然后改变遍历的方向。
            if (r >= m) {r = m - 1; c += 2; k = 1 - k;}
            //如果col超过了n-1的范围，那么col重置为n-1，并且row自增2，然后改变遍历的方向。
            if (c >= n) {c = n - 1; r += 2; k = 1 - k;}
            //如果row小于0，那么row重置0，然后改变遍历的方向。
            if (r < 0) {r = 0; k = 1 - k;}
            //如果col小于0，那么col重置0，然后改变遍历的方向。
            if (c < 0) {c = 0; k = 1 - k;}
        }
        return res;
    }

    public static void main(String[] args) {
        DiagonalTraverse d = new DiagonalTraverse();
        int[][] matrix= {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] res= d.findDiagonalOrder(matrix);
        for (int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
