package lzhou.programmingtest.leetcode.test279;

public class Solution {
    public int numSquares(int n) {
        if (n<=3) {
            return n;
        }
        int sqrtN = (int)Math.sqrt(n);
        int[] dp = new int[n+1];
        dp[0]=0;

        for (int i=1; i<=sqrtN; ++i) {
            dp[i*i] = 1;
        }
        for (int i=1; i<=n; ++i) {
            if (dp[i]==0) {
                dp[i] = Integer.MAX_VALUE;
                for (int j=(int)Math.sqrt(i); j>=1; --j) {
                    dp[i]=Math.min(dp[i], dp[i-j*j]+1);
                }
            } 
        }

        /* //Too slow
        for (int i=1; i<=n; ++i) {
            if (dp[i]==0) {
                dp[i] = Integer.MAX_VALUE;
                for (int j=1; j<=i/2; ++j) {
                    dp[i]=Math.min(dp[i], dp[j]+dp[i-j]);
                }
            } 
        }
        */

        return dp[n];
    }
}
