package lzhou.programmingtest.leetcode.test416;

import java.util.*;

/**
 * DP: knapsack
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        long sum = 0;
        for (int n:nums) {
            sum+=n;
        }
        if (sum%2==1) {
            return false;
        }
        sum/=2;
        
        boolean[] dp = new boolean[(int)sum+1];
        dp[0] = true;
        
        for (int i=0; i<nums.length; ++i) {
            for (int j=(int)sum; j>=nums[i]; --j) {
                dp[j] |= dp[j-nums[i]];
            }
            if (dp[(int)sum]) {
                return true;
            }
        }
        return false;
    }
}
