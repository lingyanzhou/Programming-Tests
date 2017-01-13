package lzhou.programmingtest.leetcode.test341;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    Stack<Queue<NestedInteger>> stackList;

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        stackList = new Stack<Queue<NestedInteger>>();
        stackList.push(new LinkedList<NestedInteger>(nestedList));
        reorder();
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        if (!hasNext()) {
            return null;
        }
        reorder();
        Integer ret = stackList.peek().poll().getInteger();
        reorder();
        return ret;
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        reorder();
        return !stackList.isEmpty();
    }

    
    private void reorder() {
        while (!stackList.isEmpty()) {
            if (stackList.peek().isEmpty()) {
                stackList.pop();
            } else if (stackList.peek().peek().isInteger()) {
                return;
            } else { //is list
                NestedInteger ni = stackList.peek().poll();
                stackList.push(new LinkedList<NestedInteger>(ni.getList()));
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
