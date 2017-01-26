package lzhou.programmingtest.leetcode.test462;

import java.util.*;

/**
 * Sort solution
 * O(nlogn)
 *    1. Suppose the final value is x. x has to be one of the values in the array.
 *    2. Then the distance to smaller values a, is x-a, to larger ones is a-x
 *    3. Increasing x by 1 will increase its distances with all smaller values  by 1, and decrease those with larger values by -1
 *    4. x has to be the median. 
 */
public class Solution {
    public int minMoves2(int[] nums) {
        if (nums.length<=1) {
            return 0;
        }
        Arrays.sort(nums);  
        int median = nums[(nums.length-1)/2];

        int ret = 0;
        for (int i: nums) {
            ret += (int)Math.abs(median-i);
        }
        return ret;
    }
}
