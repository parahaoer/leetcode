package Stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Stack<Integer> stack = new Stack();
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && T[i]> T[stack.peek()]) {
                int temp = stack.pop();
                res[temp] = i -temp;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73,74,75,71,69,72,76,73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        dailyTemperatures.dailyTemperatures(T);
    }
}
