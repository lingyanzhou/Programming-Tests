package lzhou.programmingtest.lintcode.test125;

import java.util.*;

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int[] dp = new int[m+1];
        for (int i=0; i<A.length; ++i) {
            for (int j=m; j>=A[i]; --j) {
                dp[j] = Math.max(dp[j], dp[j-A[i]]+V[i]);
            }
        }
        
        return dp[m];
    }
}
