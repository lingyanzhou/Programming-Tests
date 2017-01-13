package lzhou.programmingtest.leetcode.test209;

import java.util.*;

/* 2 pointer method
 *
 * O(n) time
 * First find the first array that satisfies the requirement
 * Move the window forward and shrink from tail
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i=0;
        int j=0;
        int subArraySum = 0;
        for (; j<nums.length && subArraySum<s; ++j) {
            subArraySum+=nums[j];
        }
        if (subArraySum<s) {
            return 0;
        }
        while (j<=nums.length) {
            subArraySum-=nums[i];
            i+=1;
            if (subArraySum<s && j==nums.length) {
                break;
            } else if (subArraySum<s) {
                subArraySum+=nums[j];
                j+=1;
            }
        }
        return j-i+1;
    }
}
