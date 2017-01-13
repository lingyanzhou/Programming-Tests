package lzhou.programmingtest.lintcode.test45;

import java.util.*;

/*DP
 * Fpr each point, find the max/min subarray from left and right
 * For each split point, calculate the difference
 *
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        long[] maxSumRight = new long[nums.length];
        long[] minSumRight = new long[nums.length];
        long[] maxSumLeft = new long[nums.length];
        long[] minSumLeft = new long[nums.length];
        
        long prevMaxSum=Integer.MIN_VALUE;
        long prevConseqPosSubArray = 0;
        for (int i=0; i<nums.length; ++i) {
            prevConseqPosSubArray+= nums[i];
            prevMaxSum = Math.max(prevConseqPosSubArray, prevMaxSum);
            prevConseqPosSubArray = Math.max(0, prevConseqPosSubArray);
            maxSumLeft[i] = prevMaxSum;
        }
        
        prevMaxSum=Integer.MIN_VALUE;
        prevConseqPosSubArray = 0;
        for (int i=nums.length-1; i>=0; --i) {
            prevConseqPosSubArray+= nums[i];
            prevMaxSum = Math.max(prevConseqPosSubArray, prevMaxSum);
            prevConseqPosSubArray = Math.max(0, prevConseqPosSubArray);
            maxSumRight[i] = prevMaxSum;
        }
        
        long prevMinSum=Integer.MAX_VALUE;
        long prevConseqNegSubArray = 0;
        for (int i=0; i<nums.length; ++i) {
            prevConseqNegSubArray+= nums[i];
            prevMinSum = Math.min(prevConseqNegSubArray, prevMinSum);
            prevConseqNegSubArray = Math.min(0, prevConseqNegSubArray);
            minSumLeft[i] = prevMinSum;
        }
        
        
        
        prevMinSum=Integer.MAX_VALUE;
        prevConseqNegSubArray = 0;
        for (int i=nums.length-1; i>=0; --i) {
            prevConseqNegSubArray+= nums[i];
            prevMinSum = Math.min(prevConseqNegSubArray, prevMinSum);
            prevConseqNegSubArray = Math.min(0, prevConseqNegSubArray);
            minSumRight[i] = prevMinSum;
        }
        
        long ret = Integer.MIN_VALUE;
        for (int i=0; i<nums.length-1; ++i) {
            ret = Math.max(ret, Math.abs(maxSumLeft[i]-minSumRight[i+1]));
            ret = Math.max(ret, Math.abs(maxSumRight[i+1]-minSumLeft[i]));
        }
        
        return (int)ret;
    }
}

