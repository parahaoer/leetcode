package twoDArray;

import java.util.ArrayList;
import java.util.List;

/*
    List set方法不能改变List的大小，所以往list里添加值时用add方法。
 */
class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList();
        for (int i=0; i<numRows; i++) {
            List<Integer> array = new ArrayList<>();
            if(i==0){
                array.add(0,1);
                l.add(array);
                continue;
            }
            array.add(0,1);

            if(i>=2) {
                for (int j=1;j<i;j++){
                    array.add(j, l.get(i-1).get(j-1) + l.get(i-1).get(j));
                }
            }

            array.add(i,1);
            l.add(array);

        }
        return l;
    }

    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        p.generate(5);
    }
}