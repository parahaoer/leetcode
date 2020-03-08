package test;

public class TestEqual {
    public static void main(String[] args) {
//        String str1 = "[null,null,null,null,null,null,null,null,true,null,true,null,true,null,null,true,null,null,null,null,false,null,false,false,null,null,true,null,null,true,null,null,null,null,null,false,null,null,null,null,false,null,null,null,null,null,null,true,null,null,null,null,null,null,false,true,null,false,false,null,true,null,true,false,null,null,null,null,false,null,true,null,null,null,null,null,true,true,null,false,null,null,null,null,null,false,null,null,null,null,null,null,null,null,false,null,null,null,true,null,null]";
//        String str2 = "[null,null,null,null,null,null,null,null,true,null,true,null,true,null,null,true,null,null,null,null,false,null,false,false,null,null,true,null,null,true,null,null,null,null,null,false,null,null,null,null,false,null,null,null,null,null,null,true,null,null,null,null,null,null,false,true,null,false,false,null,true,null,true,false,null,null,null,null,false,null,true,null,null,null,null,null,true,true,null,true,null,null,null,null,null,false,null,null,null,null,null,null,null,null,false,null,null,null,true,null,null]";
//        String str1 = "[null,null,true,null,true,null,null,true,null,null,null,null,null,null,true,null,null,null,true,null,false,true,null,null,null,null,null,null,null,true,null,null,true,null,null,null,null,null,true,null,true,null,null,null,null,null,null,false,null,null,false,null,null,false,null,null,null,null,true,null,true,true,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,true,null,null,null,null,null,null,null,null,null,false,null,null,null,null,null,null,null,null]";
//        String str2 = "[null,null,false,null,true,null,null,true,null,null,null,null,null,null,true,null,null,null,true,null,false,true,null,null,null,null,null,null,null,true,null,null,true,null,null,null,null,null,true,null,true,null,null,null,null,null,null,false,null,null,false,null,null,false,null,null,null,null,true,null,true,true,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,true,null,null,null,null,null,null,null,null,null,false,null,null,null,null,null,null,null,null]";
        String str1 = "[null,null,null,null,null,null,null,null,true,null,true,null,true,null,null,true,null,null,null,null,false,null,false,false,null,null,true,null,null,true,null,null,null,null,null,false,null,null,null,null,false,null,null,null,null,null,null,true,null,null,null,null,null,null,false,true,null,false,false,null,true,null,true,false,null,null,null,null,false,null,true,null,null,null,null,null,true,true,null,false,null,null,null,null,null,false,null,null,null,null,null,null,null,null,false,null,null,null,true,null,null]";
        String str2 = "[null,null,null,null,null,null,null,null,true,null,true,null,true,null,null,true,null,null,null,null,false,null,false,false,null,null,true,null,null,true,null,null,null,null,null,false,null,null,null,null,false,null,null,null,null,null,null,true,null,null,null,null,null,null,false,true,null,false,false,null,true,null,true,false,null,null,null,null,false,null,true,null,null,null,null,null,true,true,null,true,null,null,null,null,null,false,null,null,null,null,null,null,null,null,false,null,null,null,true,null,null]";

        System.out.println(str1.equals(str2));
        String[] arr1 = str1.split(",");
        String[] arr2 = str2.split(",");
        for(int i=0; i<arr1.length; i++) {
//            System.out.println(arr1[i] + " "+ arr2[i]);
            if(!arr1[i].equals(arr2[i])) {
                System.out.println(i);
                System.out.println(arr1[i]);
                System.out.println(arr2[i]);
            }
        }
    }
}
