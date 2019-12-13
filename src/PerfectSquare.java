public class PerfectSquare {

    int numSquares(int n) {

        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n ; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i ; j++) {
                dp[i] = Integer.min(dp[i - j *j] + 1, dp[i]);
            }
        }

        for (int i = 0; i <= n; i++) {
            System.out.println(dp[i]);
        }


        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquare perfectSquare = new PerfectSquare();
        int res = perfectSquare.numSquares(8);
        System.out.println(res);

    }
}
