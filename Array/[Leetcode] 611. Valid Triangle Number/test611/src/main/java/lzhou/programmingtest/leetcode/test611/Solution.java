package lzhou.programmingtest.leetcode.test611;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i=0;
            i<nums.length-2;
            ++i) {
            if (nums[i]==0) {
                continue;
            }
            for (int j=nums.length-1;
                j>i+1;
                --j) {
                int diff = Math.abs(nums[j]-nums[i]);
                int lower = Arrays.binarySearch(nums, i+1, j, diff);
                if (lower < 0) {
                    lower = -lower -2;
                } else {
                    while (lower+1 < nums.length && nums[lower+1]==nums[lower]) {
                        lower +=1;
                    }
                }
                result += Math.max(0, j-lower-1);
            }
        }
        return result;
    }
}

