package lzhou.programmingtest.leetcode.test213;

import java.util.*;

public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int rob(int[] nums) {
        // write your code here
        if (nums.length==0) {
            return 0;
        }
        return Math.max(houseRobber2Helper(nums, 0, nums.length-1), houseRobber2Helper(nums, 1, nums.length));
    }
    private int houseRobber2Helper(int[] nums, int start, int end) {
        // write your code here
        if (nums.length<start+1) {
            return 0;
        }
        int prev2n3 = 0;
        int prev = nums[start];
        for (int i=start+1; i<end; ++i) {
            int cur = prev2n3+nums[i];
            prev2n3 = Math.max(prev, prev2n3);
            prev=  cur;
        }
        
        return Math.max(prev, prev2n3);
    }
}
