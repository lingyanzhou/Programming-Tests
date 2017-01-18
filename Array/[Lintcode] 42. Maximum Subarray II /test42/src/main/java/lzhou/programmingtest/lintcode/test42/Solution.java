package lzhou.programmingtest.lintcode.test42;

import java.util.*;

/**
 * Forward, Backward Traversal
 *    1. Keep 2 arrays, max subarray from left and right
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(int[] nums) {
        // write your code
        int[] leftMaxSubArray = new int[nums.length];
        int[] rightMaxSubArray = new int[nums.length];
        
        leftMaxSubArray[0] = nums[0];
        rightMaxSubArray[nums.length-1] = nums[nums.length-1];
        
        int conseqArraySum = leftMaxSubArray[0];
        for (int i=1; i<nums.length; ++i) {
            conseqArraySum = Math.max(0, conseqArraySum);
            conseqArraySum += nums[i];
            leftMaxSubArray[i] = Math.max(conseqArraySum, leftMaxSubArray[i-1]);
        }
        
        conseqArraySum = rightMaxSubArray[nums.length-1];
        for (int i=nums.length-2; i>=0; --i) {
            conseqArraySum = Math.max(0, conseqArraySum);
            conseqArraySum += nums[i];
            rightMaxSubArray[i] = Math.max(conseqArraySum, rightMaxSubArray[i+1]);;
        }
        
        //System.out.println(Arrays.toString(leftMaxSubArray));
        //System.out.println(Arrays.toString(rightMaxSubArray));
        
        int ret = Integer.MIN_VALUE;
        for (int i=0; i<nums.length-1; ++i) {
            ret = Math.max(ret, leftMaxSubArray[i]+rightMaxSubArray[i+1]);
        }
        
        return ret;
    }
}
