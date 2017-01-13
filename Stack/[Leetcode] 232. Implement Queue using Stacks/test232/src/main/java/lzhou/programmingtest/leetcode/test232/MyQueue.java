package lzhou.programmingtest.leetcode.test232;

import java.util.*;

class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;
    boolean isPopping;

    public MyQueue() {
        stackIn = new Stack<Integer>();
        stackOut = new Stack<Integer>();
        isPopping = false;
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        if (isPopping) {
            prepareToPush();
        }
        stackIn.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!isPopping) {
            prepareToPop();
        }
            
        stackOut.pop();
    }

    // Get the front element.
    public int peek() {
        if (!isPopping) {
            prepareToPop();
        }
        return stackOut.peek().intValue();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if (isPopping) {
            return stackOut.isEmpty();
        } else {
            return stackIn.isEmpty();
        }
    }

    private void prepareToPop() {
        if (isPopping) {
            return;
        }
        isPopping = true;
        while (stackIn.size()>0) {
            stackOut.push(stackIn.pop());
        }
    }

    private void prepareToPush() {
        if (!isPopping) {
            return;
        }
        isPopping = false;
        while (stackOut.size()>0) {
            stackIn.push(stackOut.pop());
        }
    }
}
