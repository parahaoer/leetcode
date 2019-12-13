public class HappyNum2 {
    int digitSquareSum(int n) {
        int sum = 0;
        while (n>0) {
            int remain = n % 10;
            sum += remain * remain;
            n = n /10;
        }
        return sum;
    }

    boolean isHappy(int n) {
        int fast=n,slow = n;

        do {
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            slow = digitSquareSum(slow);
        }while(fast != slow);

        if (slow == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        HappyNum2 happyNum2 = new HappyNum2();
        boolean res = happyNum2.isHappy(19);
        System.out.println(res);
    }
}
