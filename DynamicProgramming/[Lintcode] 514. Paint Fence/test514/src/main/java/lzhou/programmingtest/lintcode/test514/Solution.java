package lzhou.programmingtest.lintcode.test514;

public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
        if (n==0 || k==0) {
            return 0;
        }
        if (n==1) {
            return k;
        }
        
        int prevSame = 0;
        int prevDiff = k;
        
        for (int i=1; i<n; ++i) {
            int tmp = prevSame;
            prevSame = prevDiff;
            prevDiff = (tmp+prevDiff)*(k-1);
        }
        
        return prevSame+prevDiff;
    }
}
