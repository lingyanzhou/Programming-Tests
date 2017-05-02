package lzhou.programmingtest.leetcode.test398;

import java.util.*;

/*
 * Reservoir sampling
 */
public class Solution {
    Random rng;
    int[] nums;
    
    public Solution(int[] nums) {
        rng = new Random();
        this.nums = nums;
    }

    public void setRng(Random rng) {
        this.rng = rng;
    }
    
    public int pick(int target) {
        int ret = -1;
        int n = 0;
        for (int i=0; i<nums.length; ++i) {
            if (nums[i]==target) {
                n+=1;
                if (rng.nextInt(n)==0) {
                    ret = i;
                }
            }
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
