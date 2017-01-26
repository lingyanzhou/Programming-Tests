package lzhou.programmingtest.leetcode.test385;

import java.util.*;

/**
 * Stack solution
 *
 *   * When a [ is read, push an emoty NestedInteger onto the stack
 *   * When a ] is read, if we are reading an integer, add the integer to the NestedInteger on the stack top, and pop the stack
 *   * When a , is read, if we are reading an integer, add the inteeger to the NestedInteger on the stack top.
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        NestedInteger fake = new NestedInteger();
        stack.push(fake);
        int val=0;
        boolean readingVal = false;
        int sign = 1;
        for (int i=0;i<=s.length(); ++i) {
            
            char c = '$';
            if (i<s.length()) {
                c= s.charAt(i);
            }
            
            if (c=='[') {
                NestedInteger tmp = new NestedInteger();
                stack.peek().add(tmp);
                stack.push(tmp);
            } else if (c==']') {
                if (readingVal) {
                    stack.peek().add(new NestedInteger(val*sign));
                    sign = 1;
                    val = 0;
                }
                readingVal=false;
                stack.pop();
            } else if (c==',' || c=='$') {
                if (readingVal) {
                    stack.peek().add(new NestedInteger(val*sign));
                    sign = 1;
                    val = 0;
                }
                readingVal=false;
            } else if (c=='-') {
                sign = -1;
            } else {
                readingVal=true;
                val = val*10+Character.digit(c,10);
            }
        }
        if (fake.getList().size()==0) {
            return fake;
        }
        return fake.getList().get(0);
    }
}
