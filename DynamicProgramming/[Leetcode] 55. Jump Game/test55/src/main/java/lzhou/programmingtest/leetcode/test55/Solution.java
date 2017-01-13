package lzhou.programmingtest.leetcode.test55;

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int canJumpTo = 0;
        for (int i=0; i<A.length && canJumpTo<A.length; ++i) {
            if (i>canJumpTo) {
                return false;
            }
            canJumpTo = Math.max(canJumpTo, i+A[i]);
        }
        return true;
    }
}
