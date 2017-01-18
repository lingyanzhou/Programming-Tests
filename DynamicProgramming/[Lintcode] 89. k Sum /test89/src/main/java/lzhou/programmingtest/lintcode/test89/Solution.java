package lzhou.programmingtest.lintcode.test89;

import java.util.*;


/**
 * Recursion+Memoization solution
 *
 * dp[i][j][k] means the count of sums of j items that is k and all j items are from index >= i
 *
 */
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return the number of possible combinations 
     */ 
    public int kSum(int[] A, int k, int target) {
        // write your code here
        Arrays.sort(A);
        int[][][] dp = new int[A.length+1][k+1][target+1];
        for (int i=0; i<=A.length; ++i) {
            dp[i][0][0] = 1;
        }
        for (int i=0; i<=A.length; ++i) {
            for (int kk=1; kk<k+1; ++kk) {
                for (int j=1; j<target+1; ++j) {
                    dp[i][kk][j] = -1;
                }
            }
        }
        return kSumHelper(A, 0, k, target, dp);
    }
    
    private int kSumHelper(int[] A, int start, int k, int target, int[][][] dp) {
        if (k<0 || target<0 || start>A.length) {
            return 0;
        }
        if (k>=dp[start].length || target>=dp[start][k].length) {
            return 0;
        }
        if (dp[start][k][target]>=0) {
            return dp[start][k][target];
        }
        int ret = 0;
        for (int i=start; i<A.length-k+1; ++i) {
            if (target-A[i]*k<0) {
                break;
            }
            ret += kSumHelper(A, i+1,  k-1, target-A[i], dp);
        }
        dp[start][k][target] = ret;
        return ret;
    }
}
