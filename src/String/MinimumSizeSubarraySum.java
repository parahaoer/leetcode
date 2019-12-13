package String;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int k=0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] + nums[k++] < s) {
                if(k== n-1) break;
            }
            if(nums[i] +nums[k]>=s) return k-i;
        }
        return  0;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        int m = minimumSizeSubarraySum.minSubArrayLen(7, nums);
        System.out.println(m);
    }

}
