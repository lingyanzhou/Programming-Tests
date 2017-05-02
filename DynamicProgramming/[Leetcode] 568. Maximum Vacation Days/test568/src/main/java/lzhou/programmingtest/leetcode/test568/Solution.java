package lzhou.programmingtest.leetcode.test568;

import java.util.*;

public class Solution 
{
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        if (N==0) {
            return 0;
        }
        int K = days[0].length;
        if (K==0) {
            return 0;
        }
        int result = 0;
        int[][] dp = new int[N][K];
        
        for (int i=0; i<N; ++i) {
            Arrays.fill(dp[i], -1);
        }
        for (int i=0; i<N; ++i) {
            if (i==0 || flights[0][i]==1) {
                result = Math.max(result, maxVacationDaysHelper(i, 0, N, K, flights, days, dp));
            }
        }
        return result;
    }

    private int maxVacationDaysHelper(int location, int week, int N, int K, int[][] flights, int[][] days, int[][] dp) {
        if (week>=K) {
            return 0;
        }
        if (dp[location][week]>=0) {
        } else {
            dp[location][week] = days[location][week];

            if (week!=K-1) {
                for (int i=0; i<N; ++i) {
                    if (i==location || flights[location][i]==1) {
                        dp[location][week] = Math.max(dp[location][week], days[location][week]+maxVacationDaysHelper(i, week+1, N, K, flights, days, dp));
                    }
                }
            }
        }

        return dp[location][week];
    }
}
