package lzhou.programmingtest.leetcode.test576;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        long[][] dp = new long[m+2][n+2];
        long[][] dpNext = new long[m+2][n+2];
        for (int l=1; l<m+1; ++l) {
            dp[l][1] += 1;
            dp[l][n] += 1;
        }
        for (int l=1; l<n+1; ++l) {
            dp[1][l] += 1;
            dp[m][l] += 1;
        }
        int result = 0;
        for (int l=0; l<N; ++l) {
            result = (int)((result+dp[i+1][j+1])%1000000007);
            for (int mm=1; mm<m+1; ++mm) {
                for (int nn=1; nn<n+1; ++nn) {
                    dpNext[mm][nn] = (((dp[mm-1][nn]+dp[mm+1][nn])%1000000007+dp[mm][nn-1])%1000000007+dp[mm][nn+1])%1000000007;
                }
            }
            
            long[][]tmp = dp;
            dp = dpNext;
            dpNext = tmp;
        }
        return result;
    }
}
