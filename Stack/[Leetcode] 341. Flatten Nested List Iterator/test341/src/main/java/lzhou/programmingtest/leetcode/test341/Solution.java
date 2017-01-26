package lzhou.programmingtest.leetcode.test341;

import java.util.*;


/**
 * Stack solution
 *
 *   * Keep a stack of NestedInteger.
 *   * Always keep the head of the stack a NestedInteger that contains a single integer.
 *   * If after poping the head, if the new head element holds a list, keep replacing the stack head with its list of nested integers 
 */
 
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<NestedInteger>();
        stack.addAll(nestedList);
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        purge();
        return stack.size()>0;
    }
    
    private void purge() {
        while (stack.size()>0 && !stack.peek().isInteger()) {
            NestedInteger ni = stack.pop();
            List<NestedInteger> l = ni.getList();
            for (int i=l.size()-1; i>=0; --i) {
                stack.addFirst(l.get(i));
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
