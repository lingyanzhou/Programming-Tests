package lzhou.programmingtest.leetcode.test62;

//DP
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n+1][m+1];
        for (int i=1; i<=m; ++i) {
            dp[1][i]=1;
        }
        for (int i=1; i<=n; ++i) {
            dp[i][1]=1;
        }
        for (int i=2; i<=n; ++i) {
            for (int j=2; j<=m; ++j) {
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[n][m];
    }
}
