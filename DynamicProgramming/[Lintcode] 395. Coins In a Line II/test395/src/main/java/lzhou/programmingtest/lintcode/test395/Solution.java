package lzhou.programmingtest.lintcode.test395;

import java.util.*;

/*
 * Dp: 
 *   maxSum[i]: max value one player can get if the player start to play at i
 *   sum[i]: sum of values from i to length.
 *   maxSum[i] = sum[i]-Math.min(maxSum[i+1], maxSum[i+2]);
 */
public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        long[] sum = new long[values.length+2];
        for (int i=values.length-1; i>=0; --i) {
            sum[i]=sum[i+1]+values[i];
        }
        long[] maxSum = new long[values.length+2];
        for (int i=values.length-1; i>=0; --i) {
            maxSum[i] = sum[i]-Math.min(maxSum[i+1], maxSum[i+2]);
        }
        return maxSum[0]>sum[0]-maxSum[0];
    }
}
