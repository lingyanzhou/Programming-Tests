package lzhou.programmingtest.leetcode.test494;

import java.util.*;

/**
 * DP:
 *   dp[i][j] means the number of combinations of nums[i..] that sum to j
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length+1][2001];
        for (int i=0; i<nums.length; ++i) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.fill(dp[nums.length], 0);
        dp[nums.length][1000]=1;
        
        return findTargetSumWaysHelper(nums, 0, S, dp);
    }
    
    public int findTargetSumWaysHelper(int[] nums, int start, int S, int[][] dp) {
        if (S>1000 || S<-1000) {
            return 0;
        }
        if (dp[start][S+1000]>=0) {
            return dp[start][S+1000];
        }
        
        int ret = 0;
        ret += findTargetSumWaysHelper(nums, start+1, S-nums[start], dp);
        ret += findTargetSumWaysHelper(nums, start+1, S+nums[start], dp);
        
        dp[start][S+1000] = ret;
        
        return ret;
    }
}
