package lzhou.programmingtest.leetcode.test42;

import java.util.*;

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        int i=0; int j=heights.length-1;
        int surrounded = 0;
        int water = 0;
        while (i<j) {
            if (heights[i]>heights[j]) {
                surrounded = Math.max(surrounded, heights[j]);
                water += surrounded-heights[j];
                j-=1;
            } else {
                surrounded = Math.max(surrounded, heights[i]);
                water += surrounded-heights[i];
                i+=1;
            }
        }
        return water;
    }
}
