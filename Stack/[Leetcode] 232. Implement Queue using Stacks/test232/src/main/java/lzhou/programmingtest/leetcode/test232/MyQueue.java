package lzhou.programmingtest.leetcode.test232;

import java.util.*;

class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<Integer>();
        stackOut = new Stack<Integer>();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        stackIn.push(x);
    }

    // Removes the element from in front of queue.
    public int  pop() {
        prepareToPop();
        return stackOut.pop();
    }

    // Get the front element.
    public int peek() {
        prepareToPop();
        return stackOut.peek().intValue();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }

    private void prepareToPop() {
        if (stackOut.size()>0) {
            return;
        }
        while (stackIn.size()>0) {
            stackOut.push(stackIn.pop());
        }
    }
}
