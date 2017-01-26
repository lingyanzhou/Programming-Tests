package lzhou.programmingtest.leetcode.test87;

import java.util.*;

/**
 * Recursion + Memoization solution
 *
 * dp[i][j][k] means that substrings s1[i...i+len] and s2[j...j+len] are scrambled
 * Transfer: dp[i][j][k] = Exists l in [1..k-1] s.t.
 *                              dp[i][j][l] && dp[i+l][j+l][k-l]
 *                           OR dp[i+k-l][j][l] && dp[i][j+l][k-l]
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length()!=s2.length() || s1.length()==0) {
            return false;
        }
        int len=s1.length();
        int[][] s1Counts = new int[len+1][26];
        int[][] s2Counts = new int[len+1][26];
        for (int i=0; i<len; ++i) {
            int cIndex = s1.charAt(i)-'a';
            for (int j=0; j<26; ++j) {
                s1Counts[i+1][j]=s1Counts[i][j];
            }
            s1Counts[i+1][cIndex]+=1;
        }
        for (int i=0; i<len; ++i) {
            int cIndex = s2.charAt(i)-'a';
            for (int j=0; j<26; ++j) {
                s2Counts[i+1][j]=s2Counts[i][j];
            }
            s2Counts[i+1][cIndex]+=1;
        }
        
        return isScramble(s1, s2, 0, 0, len, s1Counts, s2Counts, new int[len][len][len+1]);
    }
    
    public boolean isScramble(String s1, String s2, int s1Start, int s2Start, int len, int[][] s1Counts, int[][] s2Counts, int[][][] dp) {
        
        if (dp[s1Start][s2Start][len]!=0) {
            return dp[s1Start][s2Start][len]==1;
        }
        
        if (len==1) {
            if (s1.charAt(s1Start)==s2.charAt(s2Start)) {
                dp[s1Start][s2Start][len]=1;
                return true;
            } else {
                dp[s1Start][s2Start][len]=-1;
                return false;
            }
        }
        
        for (int i=0; i<26; ++i) {
            int tmp = s1Counts[s1Start+len][i]-s1Counts[s1Start][i]-(s2Counts[s2Start+len][i]-s2Counts[s2Start][i]);
            if (tmp!=0) {
                dp[s1Start][s2Start][len]=-1;
                //System.out.println("Here");
                return false;
            }
        }
        
        dp[s1Start][s2Start][len]=-1;
        for (int i=1; i<=len-1; ++i) {
            if (isScramble(s1, s2, s1Start, s2Start, i, s1Counts, s2Counts, dp) &&
                isScramble(s1, s2, s1Start+i, s2Start+i, len-i, s1Counts, s2Counts, dp) ||
                isScramble(s1, s2, s1Start, s2Start+len-i, i, s1Counts, s2Counts, dp) &&
                isScramble(s1, s2, s1Start+i, s2Start, len-i, s1Counts, s2Counts, dp)) {
                dp[s1Start][s2Start][len]=1;
                break;
            }
        }
        
        return dp[s1Start][s2Start][len]==1;
    }
    
}
