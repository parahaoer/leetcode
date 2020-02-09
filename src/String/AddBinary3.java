package String;

public class AddBinary3 {
    public String addBinary(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();



        while(m>=0 || n>=0) {
            int i,j;
            if(m>=0) i= a.charAt(m--) - '0';
            else i=0;
            if(n>=0) j = b.charAt(n--) - '0';
            else j=0;
            int sum = i + j + carry;
            //每一次遍历都要改变carry，要么为0，要么为1
            if(sum /2==1) carry = 1;
            else carry =0;
            sb.append(sum %2);
        }
        if(carry==1) sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        AddBinary3 addBinary = new AddBinary3();
        String res = addBinary.addBinary(a,b);
        System.out.print(res);
    }
}
