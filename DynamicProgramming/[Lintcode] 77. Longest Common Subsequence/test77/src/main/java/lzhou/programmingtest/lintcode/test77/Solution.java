package lzhou.programmingtest.lintcode.test77;

import java.util.*;

/*
 * Buttom Up Dp:
 *  dp[i] means the length of the longest sequence ends at index i or before.
 * Transfer:
 *  dp[i]=
 *    if (A[i]==B[i]):
 *      return prevDp[i-1]+1
 *    else:
 *      return max(dp[i-1], prevDp[i])
 *
 */
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A.length()>B.length()) {
            String tmp = B;
            B=A;
            A=tmp;
        }
        if (A.length()==0) {
            return 0;
        }
        int[] dp = new int[A.length()];
        int[] prevDp = new int[A.length()];
        
        for (int i=0; i<B.length(); ++i) {
            char b = B.charAt(i);
            for (int j=0; j<A.length(); ++j) {
                char c = A.charAt(j);
                if (c==b) {
                    if (j==0) {
                        dp[j]=1;
                    } else {
                        dp[j]=1+prevDp[j-1];
                    }
                } else {
                    if (j==0) {
                        dp[j] = prevDp[j];
                    } else {
                        dp[j] = Math.max(dp[j-1], prevDp[j]);
                    }
                }
            }

            int[] tmp = dp;
            dp = prevDp;
            prevDp = tmp;
        }

        return prevDp[A.length()-1];
    }
}
