package test;

import java.util.ArrayList;
import java.util.List;

public class testListToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        String[] test = list.toArray(new String[list.size()]);
        System.out.println(test[1]);
    }
}
