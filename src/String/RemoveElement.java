package String;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(nums.length);
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums, 3);

    }

}
