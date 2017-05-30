package lzhou.programmingtest.leetcode.test600;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public int findIntegers(int num) {
        int[][]dp = prepareDp();
        
        int result = 1;
        boolean prev1 = false;
        for (int i=31; i>=0; --i) {
            if ((num & (0x1 << i)) != 0) {
                if (prev1) {
                    for (int j=i-1; j>=0; j-=2) {
                        result += dp[j][0] + dp[j][1];
                    }
                    break;
                } else {
                    result += dp[i][0] + dp[i][1];
                    prev1 = true;
                }
            } else {
                prev1 = false;
            }
        }
        return result;
    }
    
    private int[][] prepareDp() {
        int[][]dp = new int[32][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        
        for (int i=1; i<32; ++i) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        return dp;
    }
    
    private int msb(int num) {
        assert(num>=0);
        int result = 0;
        while (num>0) {
            num = num >>> 1;
            result += 1;
        }
        return result;
    }
}
