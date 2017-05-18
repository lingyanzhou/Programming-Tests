package lzhou.programmingtest.leetcode.test394;

import java.util.*;

import java.util.stream.*;

/**
 * Non-recursive O(n) solution
 */
public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String decodeString(String s) {
        Stack<RepeatContent> stack = new Stack<RepeatContent>();
        stack.push(new RepeatContent(1));
        
        int childRepeat = 0;
        
        for (int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                childRepeat = childRepeat*10+Character.digit(c, 10);
            } else if (c=='['){
                stack.push(new RepeatContent(childRepeat));
                childRepeat = 0;
            } else if (c==']'){
                RepeatContent tmp = stack.pop();
                for (int j=0; j<tmp.repeat; ++j) {
                    stack.peek().sb.append(tmp.sb);
                }
            } else {
                stack.peek().sb.append(c);
            }
        }
        return stack.peek().sb.toString();
    }
    static class RepeatContent {
        int repeat;
        StringBuilder sb;
        RepeatContent(int rpt) {
            repeat = rpt;
            sb = new StringBuilder();
        }
    }
}
