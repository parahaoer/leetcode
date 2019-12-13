package test;

public class TestBooleanArray {
    public static void main(String[] args) {
        boolean[][] array = {{true,true,false,false}, {false, false, false,true}};
        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
