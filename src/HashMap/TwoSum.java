package HashMap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i]) ||  map.get(target - nums[i]) != i )   return new int[]{i, map.get(target - nums[i])};
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int target = 10;
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(nums, target);
    }
}
