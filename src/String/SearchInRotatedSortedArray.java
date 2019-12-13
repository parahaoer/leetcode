package String;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int flag =0;
        for(int i=0; i<n-1; i++) {
            if(nums[i] > nums[i+1]) {
                flag = i;
                break;
            }
        }

        int left =0, right = flag;
        int middle = 0;
        while(left <=right) {
            middle = (left +right)/2;
            if(nums[middle]>target) {
                right = middle -1;
            } else if(nums[middle] <target) {
                left = middle +1;
            } else if(nums[middle] == target) {
                return middle;
            }
        }

        left = flag +1;
        right=n-1;
        while(left <=right) {
            middle = (left +right)/2;
            if(nums[middle]>target) {
                right = middle -1;
            } else if(nums[middle] <target) {
                left = middle +1;
            } else if(nums[middle] == target) {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int[] nums = {};
        int n =3;
        searchInRotatedSortedArray.search(nums,n);
    }
}
