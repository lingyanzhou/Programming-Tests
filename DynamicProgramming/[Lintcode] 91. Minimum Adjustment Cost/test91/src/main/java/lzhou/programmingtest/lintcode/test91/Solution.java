package lzhou.programmingtest.lintcode.test91;

import java.util.*;

/**
 * DP
 *
 *   1. dp[i][j] means the min cost when we choose value j for A[i] and all A[0..i-1] has been chosen.
 *   2. Transfer:
 *        dp[i][j] = min(dp[i-1][j-target...j+target])+(j-A[i]);
 */
public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(int[] A, int target) {
        // write your code here
        int cost = 0;
        int[][] dp = new int[A.length][100];
        
        for (int i=0; i<A.length; ++i) {
            for (int j=0; j<100; ++j) {
                int diff = Math.abs(j+1-A[i]);
                dp[i][j]=diff;
                if (i>0) {
                    int prevMin = Integer.MAX_VALUE;
                    for (int k = Math.max(0, j-target); k<=Math.min(99, j+target);++k) {
                        prevMin = Math.min(prevMin, dp[i-1][k]);
                    }
                    dp[i][j]+=prevMin;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i:dp[A.length-1]) {
            min = Math.min(min, i);
        }
        return min;
    }
}
