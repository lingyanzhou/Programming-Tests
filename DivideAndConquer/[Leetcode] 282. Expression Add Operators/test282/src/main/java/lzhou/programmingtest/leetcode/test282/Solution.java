package lzhou.programmingtest.leetcode.test282;

import java.util.*;

/*
 * Back tracking solution
 *
 * Scans the string from left to right while trying diffent operators.
 * The helper function keeps track of what the previous operator is.
 * 
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
     * Try +, -, * and concatenate the number.
     *
     * * Simplify all expressions into this form `curval = prevval+lastMultiplication`, `lastMultiplication = coeff * lastNum`.
     * * `lastNum` is always treated as part of `lastMultiplication`. Eg. `a+b` => `a+1*b`
     * * `-` operator is treated as `+` and a unary `-`. `a-b` => `a+(-1*b)`. So we have three operator to deal with, +, *, concatenation.
     * * Do not do lookahead, because by remembering `lastNum` `lastMultiplication`, we can correct the result based on them.
     * 
     * Eg.
     *  | Some step: +    |                   |  `curval=prevval+c*b`  |  `lastMultiplication=c*b` | 
     *  | Next step:    |                     |                         |                        |
     *  |  Concatenation |      `b' = b*10+c` | `curval' = curval-b+b'` | `lastMultiplication'=lastMultiplication/b*b'=c*b'` |
     *  |  + |      `b' = c` | `curval' = curval+b'` | `lastMultiplication'=b'` |
     *  |  - |      `b' = c` | `curval' = curval+(-1)*b'` | `lastMultiplication'=-1*b''` |
     *  |  * |      `b' = c` | `curval' = curval-lastMultiplication +lastMultiplication'` | `lastMultiplication'=lastMultiplication*b'=c*b*b'` |
     *        
     * 
     * @param curVal: The value of the expression if it stops here. The value without lookahead.  
     * @param lastNum: the last number.
     * @param lastMultiplication: adjacent multiplication result.
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
