package String;

public class AddBinary4 {
    public String addBinary(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();


        int i=0, j=0;
        while(m>=0 || n>=0) {
            int sum = carry;
            i=(m>=0) ? a.charAt(m--) - '0' : 0;
            j =(n>=0) ? b.charAt(n--) - '0' : 0;
            sum += i + j;
            //每一次遍历都要改变carry，要么为0，要么为1
            carry = (sum/2==1) ? 1 : 0;

            sb.append(sum %2);
        }
        if(carry==1) sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        AddBinary4 addBinary = new AddBinary4();
        String res = addBinary.addBinary(a,b);
        System.out.print(res);
    }
}
