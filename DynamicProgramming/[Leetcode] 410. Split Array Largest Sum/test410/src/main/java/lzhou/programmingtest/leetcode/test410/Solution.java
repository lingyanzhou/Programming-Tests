package lzhou.programmingtest.leetcode.test410;

import java.util.*;

public class Solution {
    //Idea: minimax(x[i:n], m)=min(for j in (1..n-i-m): max(sum(x[i:i+j]), minimax(x[i+j:n], m-1)) );
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[m][nums.length];
        
        int sum = 0;
        for (int i=nums.length-1; i>=0; --i) {
            sum += nums[i];
            dp[0][i]=sum;
        }
        
        for (int i=1; i<m; ++i) {
            
            for (int j=nums.length-i-1; j>=0; --j) {
                int minimax = Integer.MAX_VALUE;
                for (int k=j; k<=nums.length-i-1; ++k) {
                    int tmp = Math.max(dp[0][j]-dp[0][k+1], dp[i-1][k+1]);
                    minimax = Math.min(minimax, tmp);
                    if (tmp>minimax) {
                        break;
                    }
                }
                dp[i][j]=minimax;
            }
        }
        
        return dp[m-1][0];
    }
}

