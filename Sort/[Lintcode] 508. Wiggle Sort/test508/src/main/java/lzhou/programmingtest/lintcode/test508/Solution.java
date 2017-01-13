package lzhou.programmingtest.lintcode.test508;

import java.util.*;

/*
 * Partition the array around the median. Then wiggle the array.
 */
public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        partition(nums, 0, nums.length);
        int mid = nums.length/2;
        int i=1;
        int j=nums.length-1;
        if (nums.length%2==0) {
            j-=1;
        }
        while (i<j) {
            swap(nums, i, j);
            i+=2;
            j-=2;
        }
    }
    
    private void partition(int[] nums, int start, int end) {
        // Write your code here
        if (start>=end) {
            return;
        }
        int pivot = nums[end-1];
        int ltEnd = start;
        int pivotEnd = start;
        for (int i=start; i<end; ++i) {
            if (nums[i]<pivot) {
                swap(nums, i, ltEnd);
                if (ltEnd!=pivotEnd) {
                    swap(nums, i, pivotEnd);
                }
                ltEnd+=1;
                pivotEnd+=1;
            } else if (nums[i]==pivot) {
                swap(nums, i, pivotEnd);
                pivotEnd+=1;
            }
        }
        int mid = nums.length/2;
        if (pivotEnd<=mid) {
            partition(nums, pivotEnd, end);
        } else if (ltEnd>mid) {
            partition(nums, start, ltEnd);
        }
    }
    
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
