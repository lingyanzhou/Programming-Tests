package lzhou.programmingtest.leetcode.test456;

import java.util.*;

import java.util.stream.*;

/**
 * O(n) solution
 */
public class Solution1 {
    /**
     * @param nums a list of n integers
     * @return true if there is a 132 pattern or false
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length<3) {
            return false;
        }
        int[] v1s = new int[nums.length];
        v1s[0] = nums[0];
        for (int i=1; i<nums.length; ++i) {
            v1s[i]=Math.min(v1s[i-1], nums[i]);
        }
  
        int[] v2v3 = new int[nums.length]; 
        int len = 0;
        for (int i=nums.length-1; i>=1; --i) {
            int tmp = nums[i];
            int v1 = v1s[i-1];
            while (len>0 && v2v3[len-1]<=v1) {
                len-=1;
            }
            if (tmp>v1) {
                v2v3[len] = tmp;
                len+=1;
            }
            if (len>=2 && v2v3[len-1]>v2v3[len-2]) {
                return true;
            }
        }
        return false;
    }
}
