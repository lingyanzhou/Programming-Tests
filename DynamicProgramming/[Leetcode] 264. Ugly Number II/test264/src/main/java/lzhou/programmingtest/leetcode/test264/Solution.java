package lzhou.programmingtest.leetcode.test264;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i=1; i<n; ++i) {
            dp[i] = Math.min(dp[i2]*2, dp[i3]*3);
            dp[i] = Math.min(dp[i], dp[i5]*5);
            while (dp[i2]*2<=dp[i]) {
                i2+=1;
            }
            while (dp[i3]*3<=dp[i]) {
                i3+=1;
            }
            while (dp[i5]*5<=dp[i]) {
                i5+=1;
            }
        }
        
        return dp[n-1];
    }
}
