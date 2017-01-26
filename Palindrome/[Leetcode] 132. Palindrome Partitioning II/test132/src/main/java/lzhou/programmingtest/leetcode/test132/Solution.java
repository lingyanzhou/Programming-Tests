package lzhou.programmingtest.leetcode.test132;

import java.util.*;

/**
 * DP solution.
 *   1. Find the manacher matrix.
 *   2. Use DFS+ Memoization to search for min cut.
 *
 */

public class Solution {
    public int minCut(String s) {
        int[] manacher = calcManacher(s);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        dp[dp.length-1]=0;
        return minCutHelper(s, manacher, 0, dp);
    }
    
    private int minCutHelper(String s, int[] manacher, int start, int[] dp) {
        if (dp[start]>=0) {
            return dp[start];
        }
        int ret = -1;
        for (int len=1; len<=s.length()-start; len+=1) {
            if (manacher[start*2+len]>=len) {
                int tmp = 0;
                if (start+len==s.length()) {
                    tmp = 0;
                } else {
                    tmp = 1+minCutHelper(s, manacher, start+len, dp);
                }
                if (ret==-1 || ret>tmp) {
                    ret=tmp;
                }
            }
        }
        
        dp[start]=ret;
        return ret;
    }
    
    private int[] calcManacher(String s) {
        char[] padded = new char[s.length()*2+1];
        for (int i=0; i<s.length(); ++i) {
            padded[i*2]='\0';
            padded[i*2+1]=s.charAt(i);
        }
        
        padded[padded.length-1]='\0';
        
        int[] ret = new int[padded.length];
        int index = 0;
        int len = 1;
        while (index<padded.length) {
            while (index-len>=0 && index+len<padded.length && padded[index-len]==padded[index+len]) {
                len+=1;
            }
            ret[index]=len;
            int len2=1;
            
            while (len2<len) {
                if (ret[index-len2]==len-len2) {
                    break;
                } else {
                    ret[index+len2] = Math.min(ret[index-len2], len-len2);
                }
                len2+=1;
            }
            
            len = Math.max(len-len2,1);
            index = index+len2;
        }
        
        for (int i=0; i<padded.length; ++i) {
            ret[i]-=1;
        }
        
        return ret;
    }
}
