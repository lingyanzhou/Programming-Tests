package lzhou.programmingtest.leetcode.test215;

import java.util.*;

/*
 * Quick selection:
 * Average O(n) time, inplace O(1) space
 */
class Solution {
    /*
     * @param k : k-th largest. 1-based.
     * @param nums : array of nums
     * @return: description of return
     */
    public int findKthLargest(int[] nums, int k)  {
        // write your code here
        if (nums.length==0 || k>nums.length || k<1) {
            return -1;
        }
        return kthLargestElementHelper(k-1, nums, 0, nums.length);
    }

    /**
     * @param k0: 0-based 
     */
    private int kthLargestElementHelper(int k0, int[] nums, int start, int end) {
        // write your code here
        
        int pivot = nums[start];
        int gtEnd = start;
        int pivotEnd = start+1;
        for (int i=start+1; i<end; ++i) {
            if (nums[i]==pivot) {
                swap(nums, pivotEnd, i);
                pivotEnd+=1;
            } else if (nums[i]>pivot) {
                swap(nums, gtEnd, i);
                swap(nums, pivotEnd, i);
                pivotEnd+=1;
                gtEnd+=1;
            } else {
            }
        }
        if (k0<pivotEnd && k0>=gtEnd) {
            return pivot;
        } else if (k0>=pivotEnd) {
            return kthLargestElementHelper(k0, nums, pivotEnd, end);
        } else {
            return kthLargestElementHelper(k0, nums, start, gtEnd);
        }
    }
    
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
};
