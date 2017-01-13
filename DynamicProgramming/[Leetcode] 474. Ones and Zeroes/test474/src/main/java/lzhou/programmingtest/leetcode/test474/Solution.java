package lzhou.programmingtest.leetcode.test474;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        int[][] counts = new int[strs.length][2];
        for (int i=0; i<strs.length; ++i) {
            String str = strs[i];
            getCount(str, counts[i]);
        }

        for (int i=0; i<strs.length; ++i) {
            for (int j=m; j>=counts[i][0]; --j) {
                for (int k=n; k>=counts[i][1]; --k) {
                    if (dp[j-counts[i][0]][k-counts[i][1]]!=0) {
                        dp[j][k] = Math.max(dp[j][k], dp[j-counts[i][0]][k-counts[i][1]]+1);
                    }
                }
            }
        }
        int ret = 0;
        for (int j=m; j>=0; --j) {
            for (int k=n; k>=0; --k) {
                ret = Math.max(dp[j][k], ret);
            }
        }
        return ret-1;
    }

    private void getCount(String str, int[] count) {
        count[0] = 0;
        count[1] = 0;
        for (char c: str.toCharArray()) {
            if (c=='0') {
                count[0]+=1;
            } else {
                count[1]+=1;
            }
        }
    }
}
