package String;

public class QuickSort {
    public void quickSort(int[] nums, int low, int high) {
        if(low >=high) return;
        int key = nums[low];
        int j = high;
        int i = low;
        while (i < j) {
            //找到第一个小于key的数,其索引为j
            while (i<j && nums[j] >= key) j--;
            //找到第一个大于key的数，其索引为i
            while(i<j && nums[i] <=key) i++;
            //交换i,j两个位置上的元素，让nums[i]<key<nums[j]
            if(i<j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        //交换key 和nums[i]的位置。让基准值位于中间的某个位置。
        nums[low] = nums[i];
        nums[i] = key;
        quickSort(nums, low, i-1);
        quickSort(nums, i+1, high);

    }

    public static void main(String[] args) {
        int[] nums = {6,1,2,7,9,3,4,5,10,8};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length-1);
        for (int i=0; i<nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
