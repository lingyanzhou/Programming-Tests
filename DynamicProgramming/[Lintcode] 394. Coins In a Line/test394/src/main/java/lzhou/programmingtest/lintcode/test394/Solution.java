package lzhou.programmingtest.lintcode.test394;

import java.util.*;


/*
 * Easy DP. Transfer function: f(n) = !f(n-1) || !f(n-2)
 */
public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        boolean n_1 = false;
        boolean n_0 = false;
        for (int i=1; i<=n; ++i) {
            boolean nextN0 = (!n_1) || (!n_0);
            n_1=n_0;
            n_0 = nextN0;
        }
        return n_0;
    }
}
