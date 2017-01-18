package lzhou.programmingtest.leetcode.test152;

import java.util.*;

/**
 *  DP
 *  1. Keep 2 integer, one max positive product, one min negative product. 
 *  2. When they multiply a new negative number, their sign may change, and they will be swapped.
 */
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        int ret = Integer.MIN_VALUE;
        int max = -1;
        int min = 1;
        
        for (int i : nums) {
            if (max<=0) {
                max = i;
            } else {
                max *= i;
            }
            if (min>=0) {
                min = i;
            } else {
                min *= i;
            }
            int tmpMax = max;
            max = Math.max(max, min);
            min = Math.min(tmpMax, min);
            
            ret = Math.max(ret, max);
            
            max = Math.max(-1, max); //If they are invalid, reset them to -1, 1, to avoid overflow.
            min = Math.min(1, min);
            
        }
        return ret;
    }
}
