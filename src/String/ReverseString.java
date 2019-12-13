package String;

public class ReverseString {
    public void reverseString(String[] s) {
        int len = s.length;
        for(int i=0; i<(len-1)/2; i++) {
            String temp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();

        String[] a={"A"," ","m","a","n",","," ","a"," ","p","l","a","n",","," ","a"," ","c","a","n","a","l",":"," ","P","a","n","a","m","a"};

        for (int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println(a.length);
        reverseString.reverseString(a);

        for (int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
