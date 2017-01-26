package lzhou.programmingtest.geeksforgeeks.matrixchainmultiplication;

import java.util.*;

public class Solution 
{
    public int matrixChainOrder(int p[]) {
        int[][] dp = new int[p.length-1][p.length-1];
        for (int j=1; j<dp.length; ++j) {
            for (int i=0; i<dp.length-j; ++i) {
                dp[i][i+j]=Integer.MAX_VALUE;
                for (int k=0; k<=j-1; ++k) {
                    dp[i][i+j] = Math.min(dp[i][i+j], dp[i][i+k]+dp[i+k+1][i+j]+p[i]*p[i+k+1]*p[i+j+1]);
                }
            }
        }

        return dp[0][dp.length-1];
    }
}
