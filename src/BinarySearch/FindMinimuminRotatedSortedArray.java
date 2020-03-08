package BinarySearch;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length==1 || nums[nums.length-1]> nums[0]) return nums[0];
        int lo=0;
        int hi = nums.length-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2 ;
            if(nums[mid] > nums[mid+1]) return nums[mid + 1];
            if(nums[mid] < nums[mid-1]) return nums[mid];
            if(nums[mid] > nums[0])
                lo = mid + 1;
            else
                //hi = mid-1 或者hi=mid都可以
                hi = mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        FindMinimuminRotatedSortedArray findMinimuminRotatedSortedArray = new FindMinimuminRotatedSortedArray();
        int res = findMinimuminRotatedSortedArray.findMin(nums);
        System.out.println(res);
    }
}
