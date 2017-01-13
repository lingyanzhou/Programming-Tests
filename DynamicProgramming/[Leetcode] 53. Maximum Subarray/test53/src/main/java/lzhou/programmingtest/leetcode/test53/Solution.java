package lzhou.programmingtest.leetcode.test53;


/*
 * Dp
 * curSubArray[i]: the max subarray that ends at i;
 * maxSubArray[i]: the max subarray that ends at or before i;
 *
 * Transition:
 * curSubArray[i+1] = max(curSubArray[i]+nums[i], nums[i]);
 * maxSubArray[i+1] = max(maxSubArray[i], curSubArray[i+1])
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSubArray = Integer.MIN_VALUE;
        int curSubArray = 0;
        for (int i: nums) {
            curSubArray = Math.max(curSubArray+i, i);
            maxSubArray = Math.max(maxSubArray, curSubArray);
        }
        
        return maxSubArray;
    }
}
