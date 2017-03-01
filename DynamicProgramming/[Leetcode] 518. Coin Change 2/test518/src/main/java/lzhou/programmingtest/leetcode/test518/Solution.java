package lzhou.programmingtest.leetcode.test518;

import java.util.*;

public class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length+1];
        Arrays.fill(dp[0], 1);
        for (int i=1; i<=amount; ++i) {
            for (int j=0; j<coins.length; ++j) {
                dp[i][j] = -1;
            }
        }
        return changeHelper(amount, coins, 0, dp);
    }
    
    public int changeHelper(int amount, int[] coins, int start, int[][] dp) {
        if (amount<0) {
            return 0;
        }
        if (dp[amount][start]>=0) {
            return dp[amount][start];
        }
        dp[amount][start] = 0;
        dp[amount][start] += changeHelper(amount, coins, start+1, dp);
        dp[amount][start] += changeHelper(amount-coins[start], coins, start, dp);
        return dp[amount][start];
    }
}
