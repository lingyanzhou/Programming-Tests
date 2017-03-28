package lzhou.programmingtest.leetcode.test523;

import java.util.*;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k==0) {
            boolean prev0 = false;
            for (int i=0; i<nums.length; ++i) {
                if (nums[i]==0 && prev0) {
                    return true;
                } else if (nums[i]==0) {
                    prev0=true;
                } else {
                    prev0=false;
                }
            }
            
            return false;
        } else {
            k = Math.abs(k);
            for (int i=0; i<nums.length; ++i) {
                nums[i] = nums[i]%k;
            }
            
            int sum = 0;
            Map<Integer, Integer> integralIndex = new HashMap<Integer, Integer>();
            
            integralIndex.put(0, -1);
            
            for (int i=0; i<nums.length; ++i) {
                sum = (int)(((long)nums[i]+sum)%k);
                if (integralIndex.containsKey(sum) && i-integralIndex.get(sum)>=2) {
                    return true;
                } else if (!integralIndex.containsKey(sum)) { 
                    integralIndex.put(sum, i);
                }
            }
            
            return false;
        }
    }
}
