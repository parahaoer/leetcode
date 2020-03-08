package test;

import java.util.ArrayList;
import java.util.List;

public class TestListToIntArray {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] res = list.toArray(new Integer[list.size()]);
    }
}
