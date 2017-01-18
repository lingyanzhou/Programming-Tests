package lzhou.programmingtest.leetcode.test84;

import java.util.*;

/**
 * With stack
 * O(n)
 * 
 * Brutal force idea:
 *   1. Scan from left to right; each point is the right bottom corner of some rectangulars.
 *   2. For right bottom corner, scan for left bottom corners from its rightfrom its previous point back to the first. The height of rectangulars can only decrease, while the width can only increase.
 * Redundant calculation:
 *   1. Because any candidate rectangles's height can only decrease in step 2, we can keep a stack of heights in increasing order.
 *   2. When adding a height to the stack, pop the stack until its head is smaller that the new one.
 *   3. When poping a height from the stack, we calculate only rectandulars ends at the the index and with height larger than the new one.
 *      Any rectangle with height less than the new one can be extended further to the right, and will be considered later.
 *   4. To simply the loop, we can pad the height array with one zero at each end.
*/
public class Solution2 {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        int maxArea = 0;
        int[] paddedHeight = new int[height.length+2];
        System.arraycopy(height, 0, paddedHeight, 1, height.length);
        int[] stackIndex = new int[height.length+2];
        int stackLen = 1;
        stackIndex[0] = 0;
        for (int i=1; i<paddedHeight.length; ++i) {
            while (paddedHeight[stackIndex[stackLen-1]]>paddedHeight[i]) {
                maxArea = Math.max(maxArea, paddedHeight[stackIndex[stackLen-1]]*(i-stackIndex[stackLen-2]-1));
                stackLen-=1;
            }
            stackIndex[stackLen] = i;
            stackLen+=1;
        }
        return maxArea;
    }
}
