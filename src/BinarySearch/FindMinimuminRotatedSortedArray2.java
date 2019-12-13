package BinarySearch;

public class FindMinimuminRotatedSortedArray2 {
    public int findMin(int[] nums) {
        if(nums.length==1 || nums[nums.length-1]> nums[0]) return nums[0];
        int lo=0;
        int hi = nums.length;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2 ;
            if(nums[mid] > nums[mid+1]) return nums[mid + 1];
            if(nums[mid] < nums[mid-1]) return nums[mid];
            if(nums[mid] > nums[0])
                lo = mid + 1;
            else
                //hi = mid-1 或者hi=mid都可以
                hi = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        FindMinimuminRotatedSortedArray2 findMinimuminRotatedSortedArray = new FindMinimuminRotatedSortedArray2();
        int res = findMinimuminRotatedSortedArray.findMin(nums);
        System.out.println(res);
    }
}
