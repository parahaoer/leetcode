package Array;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {

        //将minlength初始化成最大值而不是0。如果初始化为0， j-i永远大于0 ，无法改变minlength的值，始终为0
        int minlength = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++) {
            int j = i;
            int sum = 0;
            //当i位于数组的最后一个元素，如果nums[i] < s . j将越界。所以要增加条件 j < nums.length
            while(sum < s && j<nums.length) {
                sum += nums[j++];

            }
            if(sum >= s) minlength = j-i < minlength ? j-i : minlength;

        }
        //当minlength == Integer.MAX_VALUE时， 数组中所有元素加起来都没有目标值大，minlength初始化后值没有改变
        return minlength == Integer.MAX_VALUE ? 0 : minlength;
    }
}
