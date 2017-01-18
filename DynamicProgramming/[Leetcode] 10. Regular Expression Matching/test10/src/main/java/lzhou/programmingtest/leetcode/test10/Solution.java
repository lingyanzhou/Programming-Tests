package lzhou.programmingtest.leetcode.test10;

import java.util.*;

/**
 * Recursion + Memoizatin solution
 * 
 * Note boundary cases:
 *   1. * at the end
 *   2, * at the beginning
 *   3, String ends but patterns does not, and has tailing *.
 */
public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        byte[][] dp = new byte[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = 1;
        for (int i=0; i<s.length(); ++i) {
            dp[i][p.length()] = -1;
        }
        
        return isMatchHelper(s, 0, p, 0, dp);
    }
    
    private boolean isMatchHelper(String s, int i, String p, int j, byte[][] dp) {
        // write your code here
        if (i>s.length() || j>p.length()) {
            return false;
        }
        if (dp[i][j]!=0) {
            return dp[i][j]==1;
        }
        
        boolean ret= false;
        
        if (j<p.length()-1 && p.charAt(j+1)=='*') {
            if (p.charAt(j)=='.') {
                ret = isMatchHelper(s, i, p, j+2, dp) ||
                    isMatchHelper(s, i+1, p, j, dp);
            } else if (i<s.length() && p.charAt(j)==s.charAt(i)) {
                ret = isMatchHelper(s, i, p, j+2, dp) ||
                    isMatchHelper(s, i+1, p, j, dp);
            } else {
                ret = isMatchHelper(s, i, p, j+2, dp);
            }
        } else {
            if (p.charAt(j)=='.') {
                ret = isMatchHelper(s, i+1, p, j+1, dp);
            } else if (i<s.length() && p.charAt(j)==s.charAt(i)) {
                ret = isMatchHelper(s, i+1, p, j+1, dp);
            } else {
                ret = false;
            }
        }
        
        if (ret) {
            dp[i][j]=1;
        } else {
            dp[i][j]=-1;
        }
        return ret;
    }
}
