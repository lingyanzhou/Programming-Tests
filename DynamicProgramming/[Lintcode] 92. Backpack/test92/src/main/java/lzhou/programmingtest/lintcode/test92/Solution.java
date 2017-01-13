package lzhou.programmingtest.lintcode.test92;

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[] dp = new boolean[m+1];
        dp[0] = true;
        
        for (int a: A) {
            for (int j=m; j>=a; --j) {
                dp[j] |= dp[j-a];
            }
        }
        
        for (int i=m; i>=0; --i) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }
}
