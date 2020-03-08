package String;

public class SqrtX {
    public int mySqrt(int x) {
        if(x==1 || x==0) return x;
        int left=0, right=x;
        int middle =0;
        while (left <= right) {
            middle = (left + right)/2;
            if(x/middle >= middle) {
                left = middle +1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int x = 17;
        SqrtX sqrtX = new SqrtX();
        sqrtX.mySqrt(x);
    }
}
