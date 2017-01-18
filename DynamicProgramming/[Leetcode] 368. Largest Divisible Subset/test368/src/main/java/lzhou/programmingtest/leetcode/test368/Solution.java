package lzhou.programmingtest.leetcode.test368;

import java.util.*;

/**
 * Dp:
 *   1. Sort the array.
 *   2. Scan the array from largest element to smallest, calculate the LDS(i)
 *   3. LDS(i): For element i, choose an element j that is larger than i and is divisible by i and has the longest LDS. LDS(i) = 1+LDS(j).
 *   4. Keep an array of the next divisible indices. 
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] next = new int[nums.length];
        
        List<Integer> ret = new ArrayList<Integer>();
        for (int i=nums.length-1; i>=0; --i) {
            dp[i]=1;
            int longest = 0;
            int nextIndex = -1;
            for (int j=i+1; j<nums.length; ++j) {
                if (nums[j]%nums[i]==0) {
                    if (dp[j]>longest) {
                        longest=dp[j];
                        nextIndex = j;
                    }
                }
            }
            dp[i] += longest;
            next[i] = nextIndex;
        }
        int longest = 0;
        int index = -1;
        for (int i=0; i<nums.length; ++i) {
            if (dp[i]>longest) {
                longest = dp[i];
                index = i;
            }
        }
        while (index!=-1) {
            ret.add(nums[index]);
            index = next[index];
        }
        return ret;
    }
}
