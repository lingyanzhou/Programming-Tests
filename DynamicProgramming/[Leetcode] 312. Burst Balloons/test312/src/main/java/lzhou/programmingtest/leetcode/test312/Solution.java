package lzhou.programmingtest.leetcode.test312;
import java.util.*;

public class Solution {
    //Ref http://www.cnblogs.com/grandyang/p/5006441.html
    //The last element to remove acts as a boundary. So focus on the last element to remove in a range.
    public int maxCoins(int[] nums) {
        int[] padded = new int[nums.length+2];
        padded[0]=1;
        padded[padded.length-1]=1;
        System.arraycopy(nums, 0, padded, 1, nums.length);

        //DP[i][j] means how many coins we get after all elements are removed from index i to j
        int[][] dp= new int[padded.length][padded.length];
        
        for (int i=1; i<=nums.length; ++i) {
            dp[i][i] = padded[i-1]*padded[i]*padded[i+1];
        }
        
        for (int i=2; i<=nums.length; ++i) {
            for (int j=1; j+i-1<=nums.length; ++j) {
                for (int k=j; k<=j+i-1; ++k) {
                    dp[j][j+i-1] = Math.max(dp[j][j+i-1], padded[j-1]*padded[k]*padded[j+i]+dp[j][k-1]+dp[k+1][j+i-1]);
                }
            }
        }
        
        return dp[1][nums.length];
    }
}
