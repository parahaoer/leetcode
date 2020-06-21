class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        int j=0;
        int k = 0;
        for(int i=0; i<n; i++) {
            if(i == n-1) nums[j++] = nums[i];
            if(i<n-1 && nums[i] == nums[i+1]) {
                k++;
                if(k>=2) continue;
                else nums[j++] = nums[i];
            } else if(i<n-1 && nums[i] != nums[i+1]) {
                nums[j++] = nums[i];
                k=0;
            }
            
        }
        return j;
    }
}