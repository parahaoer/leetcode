package test;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List l = new ArrayList();
        l.set(0,1);
        //l.set(0,1);
        for (int i=0;i<l.size();i++){
            System.out.print(l.get(i));
        }
    }
}
