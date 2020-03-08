package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap();
        Map<String, Integer> map2 = new HashMap();
        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for(int i=0; i<list1.length; i++) {
            map.put(list1[i], i);
        }

        for(int i=0; i<list2.length; i++) {
            String key = list2[i];
            if(map.containsKey(key))
                if(map.get(key) + i < min) {
                    list.clear();
                    min = map.get(key) + i;
                    list.add(key);
                } else if(map.get(key) + i == min) {
                    list.add(key);
                }
        }
        System.out.println(list);

        String[] array = list.toArray(new String[list.size()]);
        return array;
    }

    public static void main(String[] args) {
        String[] arr1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        List list1 = Arrays.asList(arr1);
        String[] arr2 = {"KFC", "Shogun", "Burger King"};
//        List list2 = Arrays.asList(arr2);
        MinimumIndexSumofTwoLists minimumIndexSumofTwoLists = new MinimumIndexSumofTwoLists();
        String[] res = minimumIndexSumofTwoLists.findRestaurant(arr1, arr2);


    }
}
