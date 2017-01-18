package lzhou.programmingtest.lintcode.test80;

import java.util.*;

/**
 * Devide and conquer:
 * Gauranteed O(n)
 *   1. Devide the array into elements of 5
 *   2. Find each groups median. (Any sorting algorithm works)
 *   3. Find the median of median using quick selection. Use it as the pivot
 *   4. Using quick selection to partition the array.
 *   5. Recursively apply these steps on the partitioned subarray.
 */
public class Solution2 {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums.length==0) {
            return -1;
        } else if (nums.length<=5) {
            Arrays.sort(nums);
            return nums[(nums.length-1)/2];
        } else {
            return quickSelectMedian(nums, 0, nums.length);
        }
    }

    private int median(int[] nums, int s, int e) {
        if (e-s==0) {
            return -1;
        } else if (e-s<=5) {
            Arrays.sort(nums, s, e);
            return nums[(nums.length-1)/2];
        } else {
            return quickSelectMedian(nums, s, e);
        }
    }
    
    private int quickSelectMedian(int[] nums, int s, int e) {
        int k = (nums.length-1)/2;
        int[] medians = mediansOfGroups(nums, s, e);
        int pivot = median(medians);
        int pivotEnd = s;
        int ltEnd = s;
        for (int i=s; i<e; ++i) {
            if (nums[i]==pivot) {
                swap(nums, i, pivotEnd);
                pivotEnd+=1;
            } else if (nums[i]<pivot) {
                swap(nums, i, ltEnd);
                if (pivotEnd!=ltEnd) {
                    swap(nums, i, pivotEnd);
                }
                ltEnd+=1;
                pivotEnd+=1;
            }
        }
        if (pivotEnd<=k) {
            return median(nums, pivotEnd, e);
        }
        if (ltEnd>k) {
            return median(nums, s, ltEnd);
        }
        return pivot;
    }

    private int[] mediansOfGroups(int[] nums, int s, int e) {
        int[] buff = new int[(nums.length+4)/5];
        int len = 0;
        int i=s;
        for (; i+5<=e; i+=5) {
            Arrays.sort(nums, i, i+5);
            buff[len] = nums[i+2];
            len+=1;
        }
        if (i!=e) {
            Arrays.sort(nums, i, e);
            buff[len] = nums[i+(e-i-1)/2];
            
            len+=1;
        }

        return Arrays.copyOf(buff, len);
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    } 
}
