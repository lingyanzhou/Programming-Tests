class MyStack {
    ArrayList<Integer> qMaster = new ArrayList<Integer>();
    ArrayList<Integer> qTmp = new ArrayList<Integer>();
    public void push(int x) {
        qTmp.add(Integer.valueOf(x));
        while (qMaster.size() >0) {
            qTmp.add(qMaster.remove(0));
        }
        ArrayList<Integer> tmp = qTmp;
        qTmp = qMaster;
        qMaster = tmp;
        return;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (qMaster.size() >0) {
          qMaster.remove(0);
        }
        return ;
    }

    // Get the top element.
    public int top() {
        if (qMaster.size() >0) {
          return qMaster.get(0);
        }
        return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return qMaster.size()==0;
    }
}
