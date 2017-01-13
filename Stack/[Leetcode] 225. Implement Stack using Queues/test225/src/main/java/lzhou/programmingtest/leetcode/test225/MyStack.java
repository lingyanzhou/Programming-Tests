package lzhou.programmingtest.leetcode.test225;

import java.util.*;

class MyStack {
    private Queue<Integer> queue;
    private Queue<Integer> queueTmp;

    public MyStack() {
        queue = new LinkedList<Integer>();
        queueTmp = new LinkedList<Integer>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (queue.size()>1) {
            queueTmp.offer(queue.poll());
        }
        queue.poll();
        
        Queue<Integer> swap = queue;
        queue = queueTmp;
        queueTmp = swap;
    }

    // Get the top element.
    public int top() {
        int lastVal = -1;
        while (queue.size()>0) {
            lastVal = queue.poll();
            queueTmp.offer(lastVal);
        }
        
        Queue<Integer> swap = queue;
        queue = queueTmp;
        queueTmp = swap;
        return lastVal;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
