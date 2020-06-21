class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        int j=0;
        int k = 1;
        for(int i=1; i<n; i++) {
            if(nums[i] == nums[j] && k<2) {
                nums[++j] = nums[i];
                k++;
            } else if(nums[i] != nums[j]){
                nums[++j] = nums[i];
                k =1;
            }
            
        }
        return j+1;
    }
}