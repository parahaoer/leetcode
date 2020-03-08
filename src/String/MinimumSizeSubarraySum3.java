package String;

public class MinimumSizeSubarraySum3 {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, sum = 0, len = nums.length, res = len + 1;
        while (right < len) {
            while (sum < s && right < len) {
                sum += nums[right++];
            }
            while (sum >= s) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }
        return res == len + 1 ? 0 : res;
        }


    public static void main(String[] args) {
        MinimumSizeSubarraySum3 minimumSizeSubarraySum = new MinimumSizeSubarraySum3();
        int[] nums = {2,3,1,2,4,3};
        int m = minimumSizeSubarraySum.minSubArrayLen(7, nums);
        System.out.println(m);
    }

}
