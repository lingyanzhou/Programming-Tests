package lzhou.programmingtest.leetcode.test115;

import java.util.*;

/**
 * DP
 *   1. dp[i][j] means the count of s[0..i] has the number of sequence t[0..j]
 *   2. Transfer:
 *      dp[i][j] = if s[i]==t[j]: dp[i-1][j-1] + dp[i][j-1]
 *                 else: dp[i][j-1]
 */
public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        Arrays.fill(dp[0], 1);
        for (int i=0; i<t.length(); ++i) {
            int k = 0;
            for (int j=0; j<s.length(); ++j) {
                if (t.charAt(i)==s.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j]+dp[i+1][j];
                } else {
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
