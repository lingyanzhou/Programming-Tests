package lzhou.programmingtest.leetcode.test139;

import java.util.*;

/**
 * DP:
 *   1. dp[i] means whether s[0..i] can be broken down.
 *   2. Transfer:
 *      if (s[i+1..].startsWith(t)) dp[i+t.length()] = dp[i];
 */

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, List<String> dict) {
        // write your code here
        boolean[] dp = new boolean[1+s.length()];
        dp[0] = true;
        
        for (int i=0; i<s.length(); ++i) {
            if (!dp[i]) {
                continue;
            }
            for (String t: dict) {
                if (s.startsWith(t, i)) {
                    dp[i+t.length()] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
