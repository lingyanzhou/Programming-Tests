package lzhou.programmingtest.leetcode.test11;

import java.util.*;

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        int i=0;
        int j=heights.length-1;
        int ret = 0;
        while (i<j) {
            int hi = heights[i];
            int hj = heights[j];
            ret = Math.max(ret, (j-i)*Math.min(hi, hj));
            if (hi==hj) {
                i+=1;
                j-=1;
            } else if (hi<hj) {
                i+=1;
            } else {
                j-=1;
            }
        }
        return ret;
    }
}
