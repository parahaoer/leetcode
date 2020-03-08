package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack();
        int n = tokens.length;
        for(int i=0; i<n; i++) {
            String s = tokens[i];
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(s);
            }

            if(s.equals("+")) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(b+a));
            } else if( s.equals("-")) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(b-a));
            } else if( s.equals("*")) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(b*a));
            } else if( s.equals("/")) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(b/a));
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        evaluateReversePolishNotation.evalRPN(tokens);
    }
}
