package lzhou.programmingtest.leetcode.test282;

import java.util.*;

/*
 * @note Boundary cases: consequtive 0s.
 */
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> results = new ArrayList<String>();
        if (num.length()==0) {
            return results;
        }
        return addOperatorsHelper(num, 0, new StringBuilder(), target, 0, 0, 0, results);
    }
    
    /*
     * @note: lastNum represents the last number of a+b as b;
     *                                              a-b as -b;
     *                                              a*b as b.
     *        lastMultiplication represents a*b as a*b
     *                                      a+b*c as b*c
     *                                      a+b as 1*b
     *        
     */
    private List<String> addOperatorsHelper(String num, int index, StringBuilder partial, int target, long curVal, long lastNum, long lastMultiplication, List<String> results) {
        if (index == num.length() && target==curVal) {
            results.add(partial.toString());
            return results;
        } else if (index == num.length()) {
            return results;
        }
        if (index==0) {
            partial.append(num.charAt(index));
            long v = Character.digit(num.charAt(index), 10);
            addOperatorsHelper(num, 1, partial, target, v, v, v, results);
            partial.deleteCharAt(partial.length()-1);
        } else {
            long nextVal = curVal;
            int charIntVal = Character.digit(num.charAt(index), 10);
            long newNum = 0;
            long newMult = 0;
            //Extending last number
            if (lastNum!=0) {
                if (lastNum>0) {
                    newNum = lastNum*10+charIntVal;
                } else {
                    newNum = lastNum*10-charIntVal;
                }
                newMult = lastMultiplication/lastNum*newNum;
                nextVal = curVal-lastMultiplication+newMult;
                partial.append(num.charAt(index));
                addOperatorsHelper(num, index+1, partial, target, nextVal, newNum, newMult, results);
                partial.deleteCharAt(partial.length()-1);
            }
            
            //Adding the new number
            newNum = charIntVal;
            newMult = newNum;
            nextVal= curVal+newMult;
            
            partial.append('+');
            partial.append(num.charAt(index));
            addOperatorsHelper(num, index+1, partial, target, nextVal, newNum, newMult, results);
            partial.delete(partial.length()-2, partial.length());
            
            //Minus the new number
            newNum = -charIntVal;
            newMult = newNum;
            nextVal= curVal+newMult;
            
            partial.append('-');
            partial.append(num.charAt(index));
            addOperatorsHelper(num, index+1, partial, target, nextVal, newNum, newMult, results);
            partial.delete(partial.length()-2, partial.length());
            
            //Multiply the new number
            newNum = charIntVal;
            newMult = lastMultiplication*newNum;
            nextVal= curVal-lastMultiplication+newMult;
            
            partial.append('*');
            partial.append(num.charAt(index));
            addOperatorsHelper(num, index+1, partial, target, nextVal, newNum, newMult, results);
            partial.delete(partial.length()-2, partial.length());
        }
        return results;
    }
}
