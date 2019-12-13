package HashMap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k) return true;
            }
                    // else
                    //     map.put(nums[i], i);
            else
                map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        boolean res = containsDuplicateII.containsNearbyDuplicate(nums, 1);
        System.out.println(res);
    }

}
