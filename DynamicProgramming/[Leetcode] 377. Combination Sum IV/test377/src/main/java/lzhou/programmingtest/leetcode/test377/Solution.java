package lzhou.programmingtest.leetcode.test377;

import java.util.*;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return combinationSum4Helper(nums, target, dp);
        
    }
    
    public int combinationSum4Helper(int[] nums, int target, int[] dp) {
        if (target<0 || target>=dp.length) {
            return 0;
        }
        if (dp[target]>=0) {
            return dp[target];
        }
        int ret = 0;
        for (int i=0; i<nums.length; ++i) {
            ret += combinationSum4Helper(nums, target-nums[i], dp);
        }
        dp[target] = ret;
        return ret;
    }
}
