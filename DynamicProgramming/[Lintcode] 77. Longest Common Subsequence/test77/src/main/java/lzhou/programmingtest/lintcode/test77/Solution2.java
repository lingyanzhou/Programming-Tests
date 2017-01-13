package lzhou.programmingtest.lintcode.test77;

import java.util.*;

/*
 * DP: recursion+memoization
 * dp[i][j] means the length of the longest sbsequence starting from A[i] and B[j]
 * 
 * Transfer function:
 *   lca(A[i:], B[j:])
 *     if (A[i]==B[j]) :
 *       return 1+lca(A[i+1:], B[j+1:])
 *     else
 *       return max(lca(A[i:], B[j+1:]), lca(A[i+1:], B[j:]))
 *
 */
public class Solution2 {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        int[][] dp =new int[A.length()][B.length()];
        for (int i=0; i<A.length(); ++i) {
            Arrays.fill(dp[i], -1);
        }
        return longestCommonSubsequenceHelper(A.toCharArray(), 0, B.toCharArray(), 0, dp);
    }
    private int longestCommonSubsequenceHelper(char[] A, int i, char[] B, int j, int[][] dp) {
        if (i>=A.length || j>=B.length) {
            return 0;
        }
        if (dp[i][j]!=-1) {
            return dp[i][j];
        }
        int ret = 0;
        if (A[i]==B[j]) {
            ret =  1+longestCommonSubsequenceHelper(A, i+1, B, j+1, dp);
        } else {
            ret =  Math.max(longestCommonSubsequenceHelper(A, i, B, j+1, dp), longestCommonSubsequenceHelper(A, i+1, B, j, dp));
        }
        dp[i][j] = ret;
        return ret;
    }
}
