package lzhou.programmingtest.lintcode.test424;
import java.util.*;

public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        Stack<Integer> stack = new Stack<Integer>();
        for (String t: tokens) {
            if ("+".equals(t)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a+b);
            } else if ("-".equals(t)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            } else if ("*".equals(t)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            } else if ("/".equals(t)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            } else {
                stack.push(Integer.valueOf(t));
            }
        } 
        return stack.pop();
    }
}
