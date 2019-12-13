package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int k=0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] ==1) {
                k++;
                continue;
            } else {
                list.add(k);
                k=0;
            }
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }

}
