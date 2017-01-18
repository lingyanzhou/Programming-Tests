package lzhou.programmingtest.lintcode.test367;

import java.util.*;

/* Shunting-yard algorithm
 */
public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        // write your code here
        return evaluateRPN(toRPN(expression));
    }
    
    private String[] toRPN(String[] expression) {
        List<String> ret = new ArrayList<String>();
        Stack<String> operators = new Stack<String>();
        for (String e: expression) {
            if ("+".equals(e) || "-".equals(e)) {
                while (operators.size()>0 && !"(".equals(operators.peek())) {
                    ret.add(operators.pop());
                }
                operators.push(e);
            } else if ("*".equals(e) || "/".equals(e)) {
                while (operators.size()>0 && ("*".equals(operators.peek()) || "/".equals(operators.peek()))) {
                    ret.add(operators.pop());
                }
                operators.push(e);
            } else if ("(".equals(e)) {
                operators.push(e);
            } else if (")".equals(e)) {
                while (operators.size()>0 && !"(".equals(operators.peek())) {
                    ret.add(operators.pop());
                }
                if (operators.size()>0 && "(".equals(operators.peek())) {
                    operators.pop();
                }
            } else {
                ret.add(e);
            }
        }
        
        while (operators.size()>0) {
            ret.add(operators.pop());
        }
        
        return ret.toArray(new String[0]);
    }
    
    private int evaluateRPN(String[] expression) {
        Stack<Long> stack = new Stack<Long>();
        for (String e: expression) {
            if ("+".equals(e)) {
                long b = stack.pop();
                long a = stack.pop();
                stack.push(a+b);
            } else if ("-".equals(e)) {
                long b = stack.pop();
                long a = stack.pop();
                stack.push(a-b);
            } else if ("*".equals(e)) {
                long b = stack.pop();
                long a = stack.pop();
                stack.push(a*b);
            } else if ("/".equals(e)) {
                long b = stack.pop();
                long a = stack.pop();
                stack.push(a/b);
            } else {
                stack.push(Long.valueOf(e));
            }
        }
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.pop().intValue();
    }
}
