package lzhou.programmingtest.leetcode.test516;

import java.util.*;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i=0; i<dp.length; ++i) {
            Arrays.fill(dp[i], -1);
            dp[i][i]=1;
        }
        return longestPalindromeSubseqHelper(s, 0, s.length()-1, dp);
    }
    
    private int longestPalindromeSubseqHelper(String s, int start, int end, int[][] dp) {
        if (start>end) {
            return 0;
        }
        if (dp[start][end]>=0) {
            return dp[start][end];
        }
        if (s.charAt(start)==s.charAt(end)) {
            dp[start][end]=2+longestPalindromeSubseqHelper(s, start+1, end-1, dp);
        } else {
            dp[start][end] = Math.max(longestPalindromeSubseqHelper(s, start+1, end, dp), longestPalindromeSubseqHelper(s, start, end-1, dp));
        }
        return dp[start][end];
    }
}
