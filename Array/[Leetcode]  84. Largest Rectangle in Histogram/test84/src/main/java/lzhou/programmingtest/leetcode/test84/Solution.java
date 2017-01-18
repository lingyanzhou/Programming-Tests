package lzhou.programmingtest.leetcode.test84;

import java.util.*;

/**
 * Brutal force, Without stack
 * O(n^2)
 * 
 * Idea:
 *   1. Scan from left to right; each point is the right bottom corner of some rectangulars.
 *   2. For right bottom corner, scan for left bottom corners from its rightfrom its previous point back to the first. The height of rectangulars can only decrease, while the width can only increase.
 */
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        int maxArea = 0;
        for (int i=0; i<height.length; ++i) {
            int maxPossibleHeight = height[i];
            for (int j=i; j>=0; --j) {
                maxPossibleHeight = Math.min(maxPossibleHeight, height[j]);
                int area = maxPossibleHeight*(i-j+1);
                maxArea = Math.max(area, maxArea); 
            }
        }
        return maxArea;
    }
}
