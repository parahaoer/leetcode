package HashMap;

import java.util.*;

public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums1.length; i++) {
            if(map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i]) + 1);
            else
                map.put(nums1[i], 0);
        }

        for(int i=0; i<nums2.length; i++) {
            if(map.containsKey(nums2[i]))
                if(map2.containsKey(nums2[i])){
                    map2.put(nums2[i], map2.get(nums2[i]) + 1);
                    if(map2.get(nums2[i]) > map.get(nums2[i]))
                        map2.put(nums2[i], map.get(nums2[i]));
                }

                else
                    map2.put(nums2[i], 0);


        }

        List<Integer> list = new ArrayList();

        Iterator iter = map2.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            int key = (int) entry.getKey();
            int val = (int) entry.getValue();
            for(int i=0; i<=val; i++) {
                list.add(key);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        IntersectionofTwoArraysII intersectionofTwoArraysII = new IntersectionofTwoArraysII();
        intersectionofTwoArraysII.intersect(nums1,nums2);
    }
}
