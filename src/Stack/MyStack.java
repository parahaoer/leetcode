package Stack;

import java.util.*;

class MyStack {

    Queue<Integer> data = new LinkedList();
    Queue<Integer> helper = new LinkedList();
    int top ;
    
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        data.offer(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(data.size() > 1) {
            helper.offer(data.poll());
        }
        int temp = data.poll();
        while(!helper.isEmpty()) {
            //要把判断语句放在前面，因为可能初始时helper.size()就已经等于1，出队后helper.size()会等于0。判断语句内不会被执行。
            if(helper.size() == 1) {
                top = helper.peek();
            }
            data.offer(helper.poll());
        }
        return temp;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return data.isEmpty();
    }
}