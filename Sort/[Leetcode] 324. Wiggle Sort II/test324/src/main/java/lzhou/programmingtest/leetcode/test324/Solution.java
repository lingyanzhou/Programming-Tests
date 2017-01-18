package lzhou.programmingtest.leetcode.test324;

import java.util.*;

/**
 * Quick select solution
 *   1. Partition the array into half. All smaller elements in the firt half, median elements in the middle across two halves, larger ones int the second.
 *   2. Put smaller ones in odd index, larger ones in even.
 *   3. Median ones should be put first, to avoid two adjacent median elements being put together.
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length<=1) {
            return;
        }
        partitionAtHalf(nums, 0, nums.length);
        
        int mid = (nums.length-1)/2;
        int[] buff = new int[nums.length];
        for (int i=0; i<=mid; i+=1) {
            buff[2*i] = nums[mid-i];
            if (2*i+1!=nums.length) {
                buff[2*i+1] = nums[nums.length-1-i];
            }
        }
        System.arraycopy(buff, 0, nums, 0, nums.length);
    }
    
    private void partitionAtHalf(int nums[], int start, int end) {
        if (start==end) {
            return;
        }
        int pivot = nums[start];
        int pivotEnd = start +1;
        int ltEnd = start;
        
        for (int i=start+1; i<end; ++i) {
            if (nums[i]==pivot) {
                swap(nums, i, pivotEnd);
                pivotEnd += 1;
            } else if (nums[i]<pivot) {
                swap(nums, i, ltEnd);
                swap(nums, i, pivotEnd);
                pivotEnd += 1;
                ltEnd += 1;
            } else {
            }
        }
        int mid = (nums.length-1)/2;
        if (ltEnd>mid) {
            partitionAtHalf(nums, start, ltEnd);
        } else if (pivotEnd<=mid) {
            partitionAtHalf(nums, pivotEnd, end);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
