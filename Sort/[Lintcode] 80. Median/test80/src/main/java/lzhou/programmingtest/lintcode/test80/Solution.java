package lzhou.programmingtest.lintcode.test80;

import java.util.*;

/**
 * Quick selection:
 * Avg: O(n)
 * Worst: O(n^2)
 *
 */
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        return quickSelect(nums, 0, nums.length, (nums.length-1)/2);
    }
    
    private int quickSelect(int[] nums, int s, int e, int k) {
        if (s==k && e==k) {
            return nums[k];
        }
        int pivot = nums[s];
        int pivotEnd = s+1;
        int ltEnd = s;
        for (int i=s+1; i<e; ++i) {
            if (nums[i]==pivot) {
                swap(nums, i, pivotEnd);
                pivotEnd+=1;
            } else if (nums[i]<pivot) {
                swap(nums, i, ltEnd);
                swap(nums, i, pivotEnd);
                ltEnd+=1;
                pivotEnd+=1;
            }
        }
        if (pivotEnd<=k) {
            return quickSelect(nums, pivotEnd, e, k);
        }
        if (ltEnd>k) {
            return quickSelect(nums, s, ltEnd, k);
        }
        return pivot;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    } 
}
