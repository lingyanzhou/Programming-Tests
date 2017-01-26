package lzhou.programmingtest.leetcode.test467;

import java.util.*;

/**
 * DP:
 *   dp[i] means the length of the the longest substring ended in character i.
 */
public class Solution {
    public int findSubstringInWraproundString(String p) {
        int [] dp = new int[26];
        int len = 0;
        int prev = -1;
        for (int i=0; i<p.length(); ++i) {
            int c = p.charAt(i)-'a';
            if (prev!=-1 && (prev+1)%26==c) {
                len+=1;
            } else {
                len=1;
            }
            prev=c;
            dp[c] = Math.max(dp[c], len);
        }
        int sum = 0;
        for (int i:dp) {
            sum += i;
        }
        
        return sum;
    }
}
