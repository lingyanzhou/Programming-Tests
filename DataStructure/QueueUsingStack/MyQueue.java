import java.util.Stack;

class MyQueue {
     Stack<Integer> stackMaster = new Stack<Integer>();
     Stack<Integer> stackTmp = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        while (!stackMaster.empty()) {
            stackTmp.push(stackMaster.pop());
        }
        stackMaster.push(x);
        while (!stackTmp.empty()) {
            stackMaster.push(stackTmp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stackMaster.pop();
    }

    // Get the front element.
    public int peek() {
        return stackMaster.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stackMaster.empty();

    }
}
