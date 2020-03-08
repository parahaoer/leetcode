package String;

public class MinimumSizeSubarraySum2 {
    public int minSubArrayLen(int s, int[] nums) {
        int l=0,r=0,min=2147483647,sum=0;
        while(r<nums.length&&l<=r){
            while(r<nums.length&&sum<s){
                sum+=nums[r++];
            }
            while(l<=r&&sum>=s){
                min=Math.min(min,r-l);
                sum-=nums[l++];

            }
        }

        return min==2147483647?0:min;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum2 minimumSizeSubarraySum = new MinimumSizeSubarraySum2();
        int[] nums = {2,3,1,2,4,3};
        int m = minimumSizeSubarraySum.minSubArrayLen(7, nums);
        System.out.println(m);
    }

}
