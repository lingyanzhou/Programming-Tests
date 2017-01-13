package lzhou.programmingtest.lintcode.test371;
import java.util.*;

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> ret = new ArrayList<Integer>((int)Math.pow(10, n));
        if (n==0) {
            return ret;
        }
        if (n==1) {
            for (int i=1; i<10; ++i) {
                ret.add(i);
            }
            return ret;
        }
        
        List<Integer> prevResult = numbersByRecursion(n-1);
        ret.addAll(prevResult);
        int pow10 = (int)Math.pow(10, n-1);
        for (int i=1; i<10; ++i) {
            int add = i*pow10;
            ret.add(add);
            for (int p:prevResult) {
                ret.add(add+p);
            }
        }
        
        return ret;
    }
}
