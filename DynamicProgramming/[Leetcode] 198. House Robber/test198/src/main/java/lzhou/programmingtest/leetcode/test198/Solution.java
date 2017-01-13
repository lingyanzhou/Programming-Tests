package lzhou.programmingtest.leetcode.test198;

public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        long prev = 0;
        long prev2n3 = 0;
        for (int a: A) {
            long cur = prev2n3 + a;
            prev2n3 = Math.max(prev2n3, prev);
            prev = cur;
        }
        return Math.max(prev, prev2n3);
    }
}
