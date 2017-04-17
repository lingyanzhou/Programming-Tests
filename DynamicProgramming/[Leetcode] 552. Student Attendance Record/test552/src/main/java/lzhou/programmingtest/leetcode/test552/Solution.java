package lzhou.programmingtest.leetcode.test552;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public int checkRecord(int n) {
        int[][][] dp = new int[n+1][2][3];
        dp[0][0][0]=1;
        
        for (int i=1; i<n+1; ++i) {
            dp[i][0][0]=IntStream.of(dp[i-1][0][0], dp[i-1][0][1], dp[i-1][0][2]).reduce(0, (a,b)->(a+b)%1000000007);
            dp[i][0][1]=dp[i-1][0][0]%1000000007;
            dp[i][0][2]=dp[i-1][0][1]%1000000007;
            dp[i][1][0]=IntStream.of(dp[i-1][0][0], dp[i-1][0][1], dp[i-1][0][2], dp[i-1][1][0], dp[i-1][1][1], dp[i-1][1][2]).reduce(0, (a,b)->(a+b)%1000000007);
            dp[i][1][1]=dp[i-1][1][0]%1000000007;
            dp[i][1][2]=dp[i-1][1][1]%1000000007;
        }
        
        return IntStream.of(dp[n][0][0],dp[n][0][1],dp[n][0][2],dp[n][1][0],dp[n][1][1],dp[n][1][2]).reduce(0, (a,b)->(a+b)%1000000007);
    }
}
