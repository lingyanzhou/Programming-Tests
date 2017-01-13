package lzhou.programmingtest.lintcode.test79;

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        int alen = A.length();
        int blen = B.length();
        if (alen==0 || blen==0) {
            return 0;
        }
        // write your code here
        int[][] dp = new int[alen][blen];
        for (int i=0; i<alen; ++i) {
            if (A.charAt(i)==B.charAt(0)) {
                dp[i][0]=1;
            }
        }
        
        int ret = 0;
        for (int i=0; i<blen; ++i) {
            if (A.charAt(0)==B.charAt(i)) {
                dp[0][i]=1;
                ret = 1;
            }
        }
        
        for (int i=1; i<alen; ++i) {
            for (int j=1; j<blen; ++j) {
                if (A.charAt(i)==B.charAt(j)) {
                    dp[i][j] = 1+ dp[i-1][j-1];
                    ret = Math.max(ret, dp[i][j]);
                }
            }
        }
        return ret;
    }
}
