package BinarySearch;

public class FindMinimuminRotatedSortedArray2 {
    public int findMin(int[] nums) {
        if(nums.length==1 || nums[nums.length-1]> nums[0]) return nums[0];
        int lo=0;
        int hi = nums.length-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2 ;

            if(nums[mid] > nums[hi])
                lo = mid + 1;
            else if(nums[mid] < nums[hi])
                //hi = mid-1不行
                hi = mid;
            else
                hi --;
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3};
        FindMinimuminRotatedSortedArray2 findMinimuminRotatedSortedArray = new FindMinimuminRotatedSortedArray2();
        int res = findMinimuminRotatedSortedArray.findMin(nums);
        System.out.println(res);
    }
}
