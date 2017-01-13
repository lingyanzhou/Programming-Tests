package lzhou.programmingtest.leetcode.test209;

import java.util.*;

/*
 * Binary Search solution
 *
 * O(nlogn) time.
 */
public class Solution2 {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minSubArrayLen(int s, int[] nums) {
        // write your code here
        int[] sum = new int[nums.length+1];
        for (int i=0; i<nums.length; ++i) {
            sum[i+1] = sum[i]+nums[i];
        }
        
        int ret = Integer.MAX_VALUE;
        for (int i=1; i<=nums.length; ++i) {
            int target = sum[i]-s;
            int index = Arrays.binarySearch(sum, 0, i, target);
            if (index>=0) {
                while (index+1<i && sum[index+1]==target) {
                    index+=1;
                }
                ret = Math.min(ret, i-index);
            } else if (index<-1) {
                index = -1-index;
                index -=1;
                ret = Math.min(ret, i-index);
            }
            
        }
        if (ret==Integer.MAX_VALUE) {
            ret=-1;
        }
        return ret;
    }
}
