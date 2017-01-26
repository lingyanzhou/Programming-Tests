package lzhou.programmingtest.leetcode.test322;

import java.util.*;

public class Solution 
{
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE+1L);
        dp[0]=0;
        return coinChange(coins, amount, dp);
    }

    public int coinChange(int[] coins, int amount, long[] dp) {
        if (dp[amount]!=Integer.MAX_VALUE+1L) {
            return (int)dp[amount];
        }
        for (int c:coins) {
            if (c>amount) {
                continue;
            }
            int tmp = coinChange(coins, amount-c, dp);
            if (tmp!=-1) {
                dp[amount]=  Math.min(dp[amount], 1+tmp);
            }
        }
        if (dp[amount]==Integer.MAX_VALUE+1L) {
            dp[amount]=-1;
        }

        return (int)dp[amount];
    }
}
