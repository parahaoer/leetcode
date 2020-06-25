class MinStack {
    /**
        Stack<Integer> s1; 对于栈s1。栈顶元素类型是Integer。比较栈顶元素内容是否相同，使用equals方法。
     */
    Stack<Integer> s1;
    Stack<Integer> s2; 
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty() || s2.peek() >= x) s2.push(x);  

    }
    
    public void pop() {
        if(s1.peek().equals(s2.peek())) s2.pop();
        s1.pop();
        
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int min() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */