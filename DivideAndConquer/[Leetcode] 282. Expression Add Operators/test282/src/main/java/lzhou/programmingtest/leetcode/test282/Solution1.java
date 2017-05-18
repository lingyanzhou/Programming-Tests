package lzhou.programmingtest.leetcode.test282;

import java.util.*;

/**
 * Divide and conquer solution
 *
 * * Recursively divide the string by `+`, `-`, `*` into two parts, or simply parse it as integer value.
 * * To deal with preprecedence, we restrict what can be nested. 
 *     * If the string is divided by `+`, it can be further divided by `+` (for the fisrt part only), `-`, `*`
 *     * If the string is divided by `-`, it can be further divided by `-` (for the fisrt part only), `*`. 
 *     * If the string is divided by `*`, it can be further divided by `*`
 * * To eliminate duplication, we futher forbid the use of the same divisor in the second part. So the divisor position we use at this level will be the rightmost divisor position for nested levels.
 * * Another reason to fix the rightmost divisor first is to deal with the left-associtivity of `-`.
 */
public class Solution1 {
    /**
     * @param num a string contains only digits 0-9
     * @param target an integer
     * @return return all possibilities
     */
    public List<String> addOperators(String num, int target) {
        List<ExpressionResult> expRes = simpleValue(num);
        expRes.addAll(addPlus(num));
        expRes.addAll(addMinus(num));
        expRes.addAll(addMultiply(num));
        List<String> result = new ArrayList<String>();
        for (ExpressionResult er: expRes) {
            if (er.result==target) {
                result.add(er.expr);
            }
        }
        
        return result;
    }
    
    private List<ExpressionResult> addPlus(String num) {
        List<ExpressionResult> result = new ArrayList<ExpressionResult>();
        for (int i=1; i<num.length(); ++i) {
            String sub1 = num.substring(0, i);
            String sub2 = num.substring(i, num.length());
            List<ExpressionResult> l1 = addPlus(sub1);
            l1.addAll(addMinus(sub1));
            l1.addAll(addMultiply(sub1));
            l1.addAll(simpleValue(sub1));
            List<ExpressionResult> l2 = addMinus(sub2);
            l2.addAll(addMultiply(sub2));
            l2.addAll(simpleValue(sub2));
            
            for (ExpressionResult e1 : l1) {
                for (ExpressionResult e2 : l2) {
                    result.add(new ExpressionResult(e1.expr+"+"+e2.expr, e1.result+e2.result));
                }
            }
        }
        return result;
    }

    private List<ExpressionResult> addMinus(String num) {
        List<ExpressionResult> result = new ArrayList<ExpressionResult>();
        for (int i=1; i<num.length(); ++i) {
            String sub1 = num.substring(0, i);
            String sub2 = num.substring(i, num.length());
            List<ExpressionResult> l1 = addMinus(sub1);
            l1.addAll(addMultiply(sub1));
            l1.addAll(simpleValue(sub1));
            List<ExpressionResult> l2 = addMultiply(sub2);
            l2.addAll(simpleValue(sub2));
            
            for (ExpressionResult e1 : l1) {
                for (ExpressionResult e2 : l2) {
                    result.add(new ExpressionResult(e1.expr+"-"+e2.expr, e1.result-e2.result));
                }
            }
        }
        return result;
    }

    private List<ExpressionResult> addMultiply(String num) {
        List<ExpressionResult> result = new ArrayList<ExpressionResult>();
        for (int i=1; i<num.length(); ++i) {
            String sub1 = num.substring(0, i);
            String sub2 = num.substring(i, num.length());
            List<ExpressionResult> l1 = addMultiply(sub1);
            l1.addAll(simpleValue(sub1));
            List<ExpressionResult> l2 = simpleValue(sub2);
            
            for (ExpressionResult e1 : l1) {
                for (ExpressionResult e2 : l2) {
                    result.add(new ExpressionResult(e1.expr+"*"+e2.expr, e1.result*e2.result));
                }
            }
        }
        return result;
    }

    private List<ExpressionResult> simpleValue(String num) {
        List<ExpressionResult> result = new ArrayList<ExpressionResult>();
        if (num.length()==0 || (num.length()>1 && num.charAt(0)=='0')) {
            return result;
        }
        try {
            long val = Long.parseLong(num);
            result.add(new ExpressionResult(num, val));
        } catch (Exception e) {
        }
        return result;
    }
    
    private static class ExpressionResult {
        String expr;
        long result;
        ExpressionResult(String expr, long result) {
            this.expr = expr;
            this.result = result;
        }
    }
}
