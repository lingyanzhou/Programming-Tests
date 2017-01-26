package lzhou.programmingtest.leetcode.test486;

import java.util.*;

/**
 * DP
 *
 * dp[i][j] means the max amount a player can get if it's her turn and the array as elements i..j left.
 * Transfer func: dp[i][j] = max( num[i]+sum(num[i+1..j])-dp[i+1][j],
 *                                num[j]+sum(num[i..j-1])-dp[i][j-1])
 * 
 * Idea:
 *     1. If the array length is even, the first player can force the the second player to always choose even or odd elements. Thus the first player can always win.
 *     2. If the array length is odd, we use dp.
 *     
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length%2==0) {
            return true;
        } else {
            long[][] dp = new long[nums.length][nums.length];
            for (int i=0; i<nums.length; ++i) {
                Arrays.fill(dp[i], -1);
                dp[i][i]=nums[i];
            }
            long[] sum = calcSum(nums);
            long maxGain = maximizeGain(nums, sum, 0, nums.length-1, dp);
            if (maxGain*2>=sum[nums.length]) {
                return true;
            }
            return false;
        }
    }

    private long maximizeGain(int[] nums, long[] sum,  int first, int last, long[][] dp) {
        if (dp[first][last]>=0) {
            return dp[first][last];
        }
        long ret = 0;

        ret = nums[first]+sum[last+1]-sum[first+1]-maximizeGain(nums, sum, first+1, last, dp);
        ret = Math.max(ret, nums[last]+sum[last]-sum[first]-maximizeGain(nums, sum, first, last-1, dp));

        dp[first][last] = ret;
        return ret;
    }

    private long[] calcSum(int[] nums) {
        long[] sum = new long[nums.length+1];
        for (int i=0; i<nums.length; ++i) {
            sum[i+1] = sum[i]+nums[i];
        }
        return sum;
    }
}
