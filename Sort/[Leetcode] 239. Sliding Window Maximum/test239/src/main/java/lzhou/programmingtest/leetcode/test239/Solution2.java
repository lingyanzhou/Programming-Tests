package lzhou.programmingtest.leetcode.test239;

import java.util.*;


/*
 * Forward-Reversetraversal Solution
 * Idea:
 *   1. Split the array into k-length sections.
 *   2. Each window will either contain a whole section, or cross the border between two section.
 *   3. For each section, we keep two arrays, containing maximum when traversing from left and right (denoted as leftMax and rightMax).
 *   4. The sliding window maximum will be the maximum of rightmost value of the leftMax and the leftmost value of the rightMax within the window.
 *     (When the window does not align with the section, we can imaging the window is splitted by the section boundary, its left part max is from the rightMax, and its right part max is from the leftMax)
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k<=1) {
            return nums;
        }
        int[] ret = new int[nums.length-k+1];

        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        
        for (int i=0; i<nums.length; ++i) {
            int prev = 0;
            if (i%k==0) {
                prev = Integer.MIN_VALUE;
            } else {
                prev = leftMax[i-1];
            }
            leftMax[i] = Math.max(prev, nums[i]);
        }

        for (int i=nums.length-1; i>=0; --i) {
            int prev = 0;
            if (i%k==0 || i==nums.length-1) {
                prev = Integer.MIN_VALUE;
            } else {
                prev = rightMax[i+1];
            }
            rightMax[i] = Math.max(prev, nums[i]);
        }

        for (int i=0; i<ret.length; ++i) {
            ret[i] = Math.max(rightMax[i], leftMax[i+k-1]);
        }
        
        return ret;
    }
}
