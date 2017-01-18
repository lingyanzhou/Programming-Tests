package lzhou.programmingtest.leetcode.testtest97;

import java.util.*;

/**
 * DP:
 *   1. dp[i][j] means s1[0..i] and s2[0..j] can form s3[0..i+j-1]
 *   2. Transfer function: dp[i][j] =   if dp[i-1][j], s3[i+j-1]==s1[i-1]
 *                                      else if dp[i][j-1], s3[i+j-1]==s2[j-1]
 *                                      else false
 */
public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1.length()+s2.length()!=s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        
        for (int i=1; i<=s2.length(); ++i) {
            if (s3.charAt(i-1)!=s2.charAt(i-1)) {
                break;
            }
            dp[0][i] = true;
        }
        
        for (int i=1; i<=s1.length(); ++i) {
            if (s3.charAt(i-1)!=s1.charAt(i-1)) {
                break;
            }
            dp[i][0] = true;
        }
        
        for (int i=1; i<=s1.length(); ++i) {
            for (int j=1; j<=s2.length(); ++j) {
                dp[i][j] = (dp[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1)) ||
                    (dp[i][j-1] && s3.charAt(i+j-1)==s2.charAt(j-1));
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}
