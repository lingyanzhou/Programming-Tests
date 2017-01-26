package lzhou.programmingtest.leetcode.test462;

import java.util.*;

/**
 * Quick Select solution
 * O(n)
 *    1. Suppose the final value is x. x has to be one of the values in the array.
 *    2. Then the distance to smaller values a, is x-a, to larger ones is a-x
 *    3. Increasing x by 1 will increase its distances with all smaller values  by 1, and decrease those with larger values by -1
 *    4. x has to be the median. 
 */
public class Solution2 {
    public int minMoves2(int[] nums) {
        if (nums.length<=1) {
            return 0;
        }
         
        int median = quickSelect(nums, 0, nums.length, (nums.length-1)/2);

        int ret = 0;
        for (int i: nums) {
            ret += (int)Math.abs(median-i);
        }
        return ret;
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        swap(nums, end-1, start);
        int pivot = nums[start];
        int pivotEnd = start+1;
        int ltEnd = start;
        for (int i=start+1; i<end; ++i) {
            if (nums[i]==pivot) {
                swap(nums, i, pivotEnd);
                pivotEnd+=1;
            } else if (nums[i]<pivot) {
                swap(nums, i, ltEnd);
                swap(nums, i, pivotEnd);
                ltEnd+=1;
                pivotEnd+=1;
            } else {
            }
        }
        if (pivotEnd>k && ltEnd<=k) {
            return pivot;
        } else if (ltEnd>k) {
            return quickSelect(nums, start, ltEnd, k);
        } else {
            return quickSelect(nums, pivotEnd, end, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
