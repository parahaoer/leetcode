package test;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map map= new HashMap();
        map.put(1, 2);
        map.put(1, 3);
        System.out.println(map.get(1));
    }
}
