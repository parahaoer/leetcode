class Solution {
    /*
    将 数组中 0 往左边堆， 将数组中2 往右边堆
    当交换数组中2 时，指针i 不向前走。因为如果与2交换的是0，还需要把0交换到左边去
    */
    public void sortColors(int[] nums) {
        int lt = -1, gt = nums.length;
        
        for(int i=0; i< gt;) {
            if(nums[i] == 2) {
                gt --;
                
                int temp = nums[i];
                nums[i] = nums[gt];
                nums[gt] = temp;
            } else if(nums[i] == 0) {
                lt ++;
                int temp = nums[i];
                nums[i] = nums[lt];
                nums[lt] = temp;
                i++;
            } else {
                i++;
            }
        }
    }
}