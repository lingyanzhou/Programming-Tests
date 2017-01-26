package lzhou.programmingtest.lintcode.test3;

import java.util.*;

/**
 * http://www.hawstein.com/posts/20.4.html
 *
 * Idea:
 *   1. Count how many that digit can appear at a specific place.
 *   2. Let the digit we are probing be k (k!=0), i-th digit of n be l, then the count k appear at i is
 *
 * ```
 * if (l>k):
 *   count = (hight+1)*10^i
 * else if l==k
 *   count = (hight)*10^i+low+1
 * else if l < k:
 *   count = (hight)*10^i
 * ```
 *
 * If k=0, [high] cannot be zero, then count is:
 *
 * ```
 * if (l==0) {
 *   tmp = (high-1)*10^i+low+1;
 * } else {
 *   tmp = (high)*10^i
 * }
 * ```
 */
class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code her
        if (k==0) {
            return zeroDigitCounts(n);
        } else {
            return nonZeroDigitCounts(k,n);
        }
    }
    
    private int zeroDigitCounts(int n) {
        int d = 0;
        while (n/(int)Math.pow(10, d)>0) {
            d+=1;
        }
        int ret= 0;
        for (int i=d-2; i>=0; --i) {
            int high = n/(int)Math.pow(10,i+1);
            int l = n/(int)Math.pow(10,i)%10;
            int low = n%(int)Math.pow(10,i);
            
            int tmp = 0;
            if (l==0) {
                tmp = (high-1)*(int)Math.pow(10, i)+low+1;
            } else {
                tmp = (high)*(int)Math.pow(10, i);
            }
            //System.out.println(tmp);
            ret+= tmp;
        }
        return ret+1;
    }
    
    private int nonZeroDigitCounts(int k, int n) {
        // write your code her
        int d = 0;
        while (n/(int)Math.pow(10, d)>0) {
            d+=1;
        }
        int ret= 0;
        for (int i=d-1; i>=0; --i) {
            int high = n/(int)Math.pow(10,i+1);
            int l = n/(int)Math.pow(10,i)%10;
            int low = n%(int)Math.pow(10,i);
            
            int tmp = 0;
            if (l>k) {
                tmp= (high+1)*(int)Math.pow(10,i);
            } else if (l==k) {
                tmp= 1+high*(int)Math.pow(10,i)+low;
            } else {
                tmp= high*(int)Math.pow(10,i);
            }
            ret+= tmp;
            //System.out.println(tmp);
        }
        return ret;
    }
}
