package lzhou.programmingtest.leetcode.test155;
import java.util.*;

public class MinStack {
    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        minStack.push(Integer.valueOf(Integer.MAX_VALUE));
    }
    
    public void push(int x) {
        int curMin = minStack.peek().intValue();
        curMin = Math.min(curMin, x);
        stack.push(Integer.valueOf(x));
        minStack.push(Integer.valueOf(curMin));
    }
    
    public void pop() {
        if (stack.size()>0) {
            stack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek().intValue();
    }
    
    public int getMin() {
        return minStack.peek().intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
