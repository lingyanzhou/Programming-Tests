package lzhou.programmingtest.leetcode.test16;

import java.util.*;

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int ret = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for (int i=0; i<nums.length-2; ++i) {
            int newTarget = target - nums[i];
            
            int j=i+1;
            int k=nums.length-1;
            
            while (j<k) {
                int diff = Math.abs(nums[j]+nums[k]-newTarget);
                if (minDiff>diff) {
                    minDiff = diff;
                    ret = nums[j]+nums[k]+nums[i];
                }
                if (nums[j]+nums[k]==newTarget) {
                    return ret;
                } else if (nums[j]+nums[k]<newTarget) {
                    j+=1;
                } else {
                    k-=1;
                }
            }
        }
        return ret;
    }
}
