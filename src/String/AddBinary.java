package String;

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int alen = charA.length;
        int blen = charB.length;
        int carray = 0;
        int sum = 0;
        StringBuilder sbStr = new StringBuilder();
        while (alen>0 || blen>0 ) {
            //取出二进制每一位的数
            int i =  alen >0 ? Character.getNumericValue(charA[--alen]) : 0;
            int j =  blen >0 ? Integer.parseInt(String.valueOf(charB[--blen])) : 0;
            //二进制加法 按位与
            sum = i ^ j ^ carray;
            //进位
            carray = (i+j+carray>=2) ? 1 : 0 ;
            sbStr.append(sum);
            if(alen==0 && blen==0 && carray ==1) {
                sbStr.append(1);
            }
        }
        return sbStr.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1111", b = "1111";
        AddBinary addBinary = new AddBinary();
        String res = addBinary.addBinary(a,b);
        System.out.print(res);
    }
}
