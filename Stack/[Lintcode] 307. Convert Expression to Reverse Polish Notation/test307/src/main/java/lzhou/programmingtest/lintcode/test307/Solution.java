package lzhou.programmingtest.lintcode.test307;

import java.util.*;

/*
 * Shunting-yard algorithm
 */
public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public List<String> convertToRPN(String[] expression) {
        // write your code here
        List<String> ret = new ArrayList<String>(expression.length);
        Stack<String> operators = new Stack<String>();
        for (String s: expression) {
            if ("+".equals(s) || "-".equals(s)) {
                while (operators.size()>0 && !"(".equals(operators.peek())) {
                    ret.add(operators.pop());
                }
                operators.push(s);
            } else if ("*".equals(s) || "/".equals(s)) {
                while (operators.size()>0 && ("*".equals(operators.peek()) || "/".equals(operators.peek()))) {
                    ret.add(operators.pop());
                }
                operators.push(s);
            } else if (")".equals(s)) {
                while (operators.size()>0 && !"(".equals(operators.peek())) {
                    ret.add(operators.pop());
                }
                operators.pop();
            } else if ("(".equals(s)) {
                operators.push(s);
            } else {
                ret.add(s);
            }
        }
        while (operators.size()>0) {
            ret.add(operators.pop());
        }
        return ret;
    }
}
