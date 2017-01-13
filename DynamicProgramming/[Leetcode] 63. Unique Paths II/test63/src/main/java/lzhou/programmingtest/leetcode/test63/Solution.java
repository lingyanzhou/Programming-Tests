package lzhou.programmingtest.leetcode.test63;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length==0 || obstacleGrid[0].length==0) {
            return 0;
        }
        if (obstacleGrid[0][0]==1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0]=1;

        for (int i=1; i<obstacleGrid.length; ++i) {
            if (obstacleGrid[i][0]==0) {
                dp[i][0] = dp[i-1][0];
            } else {
                break;
            }
        }
        for (int i=1; i<obstacleGrid[0].length; ++i) {
            if (obstacleGrid[0][i]==0) {
                dp[0][i] = dp[0][i-1];
            } else {
                break;
            }
        }

        for (int i=1; i<obstacleGrid.length; ++i) {
            for (int j=1; j<obstacleGrid[i].length; ++j) {
                if (obstacleGrid[i][j]==0) {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
