package lzhou.programmingtest.leetcode.test456;

import java.util.*;

import java.util.stream.*;

/**
 * O(n^2) solution
 */
public class Solution {
    /**
     * @param nums a list of n integers
     * @return true if there is a 132 pattern or false
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length<3) {
            return false;
        }
        int v1 = nums[0];
        for (int i=0; i<nums.length; ++i) {
            v1=Math.min(v1, nums[i]);
            int v2 = v1;
            int v3 = v1;
            for (int j=i+1; j<nums.length; ++j) {
                v3 = Math.max(v3, nums[j]);
                v2 = nums[j];
                if (v2>v1 && v2<v3) {
                    return true;
                }
            }
        }
        return false;
    }
}
