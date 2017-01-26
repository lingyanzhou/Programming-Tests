package lzhou.programmingtest.lintcode.test437;

import java.util.*;

/**
 * Binary search solution
 * Time O(n*log(sum(A)))
 * 
 *   1. Lower bound is the max of all books.
 *   2. The upper bound is the sum of all books.
 *   3. As we increase k, the results must not increase, and vise versa.
 */
public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        long sum = 0;
        int max = 0;
        for (int p: pages) {
            sum += p;
            max = Math.max(max, p);
        }
        long upper = sum+1;
        long lower = max;
        while (lower<upper) {
            long mid = (upper+lower)/2;
            if (tryMax(pages, mid, k)) {
                upper = mid;
            } else {
                lower = mid+1;
            }
        }
        return (int)lower;
    }
    
    private static boolean tryMax(int[] pages, long max, int k) {
        long curSum = 0;
        for (int p:pages) {
            curSum+=p;
            if (curSum>max) {
                if (p>max) {
                    return false;
                }
                curSum=p;
                k-=1;
            }
            if (k==0) {
                return false;
            }
        }
        return true;
    }
}
