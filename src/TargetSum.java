public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum < S || (sum + S) % 2 != 0){
            return 0;
        }
        sum = (sum + S) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums){
            for (int i = sum; i >= num; i--){
                dp[i] += dp[i - num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        TargetSum targetSum = new TargetSum();
        int res = targetSum.findTargetSumWays(nums, 3);
        System.out.println(res);

    }
}
