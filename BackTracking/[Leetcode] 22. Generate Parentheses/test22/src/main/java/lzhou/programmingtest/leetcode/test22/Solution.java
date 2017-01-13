package lzhou.programmingtest.leetcode.test22;

import java.util.*;

public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        // Write your code here
        return generateParenthesisHelper(n, 0, 0, new char[2*n], new ArrayList<String>());
    }
    
    private List<String> generateParenthesisHelper(int total, int opened, int closed, char[] partial, List<String> result) {
        if (closed==total) {
            result.add(new String(partial));
            return result;
        }
        if (opened<total) {
            partial[opened+closed]='(';
            generateParenthesisHelper(total, opened+1, closed, partial, result);
        }
        
        if (closed<opened) {
            partial[opened+closed]=')';
            generateParenthesisHelper(total, opened, closed+1, partial, result);
        }
        return result;
    }
}
