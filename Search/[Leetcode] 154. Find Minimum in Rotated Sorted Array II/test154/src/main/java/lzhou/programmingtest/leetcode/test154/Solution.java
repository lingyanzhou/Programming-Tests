package lzhou.programmingtest.leetcode.test154;

import java.util.*;

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums.length==0) {
            return 0;
        }
        int lastVal = nums[nums.length-1];
        int l=0;
        int r=nums.length;
        while (l<r) {
            int mid = (int)((long)(l+r)/2);
            if (nums[mid]>lastVal) {
                l=mid+1;
            } else if (nums[mid]<lastVal) {
                r=mid;
            } else {
                boolean isLeftOfMin = false;
                for (int i=mid+1; i<nums.length; ++i) {
                    if (nums[i]!=lastVal) {
                        isLeftOfMin = true;
                        break;
                    }
                }
                if (isLeftOfMin) {
                    l=mid+1;
                } else {
                    r=mid;
                }
            }
        }
        return nums[l];
    }
}
