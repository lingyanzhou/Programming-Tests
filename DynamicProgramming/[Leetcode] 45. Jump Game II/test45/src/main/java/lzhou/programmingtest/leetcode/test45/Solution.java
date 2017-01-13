package lzhou.programmingtest.leetcode.test45;
import java.util.*;

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public int jump(int[] A) {
        // wirte your code here
        int canJumpTo = 0;
        int curPos = 0;
        int step = 0;
        for (int i=0; i<A.length; ++i) {
            if (canJumpTo<i) {
                return Integer.MAX_VALUE;
            }
            canJumpTo = Math.max(canJumpTo, i+A[i]);
            if (i<A.length-1 && curPos==i) {
                step+=1;
                curPos = canJumpTo;
            }
        }
        return step;
    }
}
