package lzhou.programmingtest.lintcode.test43;

import java.util.*;

public class Solution 
{
    /**
    * @param nums: A list of integers
    * @param k: An integer denote to find k non-overlapping subarrays
    * @return: An integer denote the sum of max k non-overlapping subarrays
    */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        long[][] dp=new long[nums.length][k+1];
        for (int i=0; i<nums.length; ++i) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }
        return maxSubArrayHelper(nums, 0, k, dp);
    }
    
    public int maxSubArrayHelper(int[] nums, int start, int k, long[][] dp) {
        if (k==0) { 
            return 0;
        }
        if (nums.length==start) {
            return Integer.MIN_VALUE;
        }
        if (dp[start][k]!=Long.MIN_VALUE) {
            return (int)dp[start][k];
        }
        long kSubArrayMax = Long.MIN_VALUE;
        long curMax = 0;
        for (int i=start; i< nums.length-k+1; ++i) {
            curMax += nums[i];
            kSubArrayMax = Math.max(kSubArrayMax, curMax+maxSubArrayHelper(nums, i+1, k-1, dp));
            if (curMax<0) {
                curMax=0;
            }
        }
        dp[start][k]=kSubArrayMax;
        return (int)kSubArrayMax;
    }
}
