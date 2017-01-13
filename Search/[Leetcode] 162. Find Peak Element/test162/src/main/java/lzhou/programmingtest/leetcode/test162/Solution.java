package lzhou.programmingtest.leetcode.test162;

/*
 * Idea:
 * 1. The boundaries are considered -inf. So the leftnmost slope is positive, the rightmost negative.
 * 2. In between a positive and a negative slope, and every element is distinct, there has to be a peak.
 * 3. If the mid point slope is positive, we search the right part. If it is negative, we search the left;
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length==1) {
            return 0;
        }
        int start = 0;
        int end = nums.length;
        int mid = (start+end)/2;
        while (start<end) {
            mid = (start+end)/2;
            if (mid==0) {
                if (nums[0]>nums[1]) {
                    return 0;
                } else {
                    start=mid+1;
                }
            } else if (mid==nums.length-1) {
                if (nums[nums.length-1]>nums[nums.length-2]) {
                    return nums.length-1;
                } else {
                    end = mid;
                }
            } else {
                if (nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid]) {
                    return mid;
                } else if (nums[mid-1]<nums[mid] && nums[mid+1]>nums[mid]) {
                    start = mid+1;
                } else if (nums[mid-1]>nums[mid] && nums[mid+1]<nums[mid]) {
                    end = mid;
                } else {
                    if (end-mid-1>mid-start) {
                        end = mid;
                    } else {
                        start = mid+1;
                    }
                }
            }
        }
        return -1;
    }
}
