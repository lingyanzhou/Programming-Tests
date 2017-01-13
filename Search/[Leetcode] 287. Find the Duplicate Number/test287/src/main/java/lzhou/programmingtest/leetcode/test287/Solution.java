package lzhou.programmingtest.leetcode.test287;

import java.util.*;

//(Pigeonhole_principle) Binary search the number, count how many are below the middle point. The dulicated is on the side where the count is more than the value range.

public class Solution {
        public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        int l = 1;
        int u = n+1;
        while (l<u) {
            int mid = (int)(((long)l+u)/2);
            if (countInRange(nums, l, mid)>mid-l) {
                u=mid;
            } else if (countInRange(nums, mid+1, u)>u-mid-1) {
                l = mid+1;
            } else {
                return mid;
            }
        }
        return l;
    }
    
    private int countInRange(int[] nums, int l, int u) {
        if (l>=u) {
            return 0;
        }
        int count = 0;
        for (int i:nums) {
            if (i>=l && i<u) {
                count+=1;
            }
        }
        return count;
    }
}
