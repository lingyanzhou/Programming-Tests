package lzhou.programmingtest.leetcode.test287;

import java.util.*;

/*Loop detection
 * REF:http://keithschwarz.com/interesting/code/?dir=find-duplicate
 * 
 * The value in nums indicate where we go next.
 * Follow each index one step, we must visit the same index twice (pigion hol principle)
 * Starting from any index, we must be moving in a circle, or a P shaped sequnce.
 * P shaped sequence means the current sequnce contains the duplicate and is one index prior to the intersection.
 * Since n+1 elements contains 1..n n numbrs, the last index can never be visited. If we start here, we will be in P shaped sequnce.
 */

public class Solution2 {
    public int findDuplicate(int[] nums) {
        int n=nums.length-1;
        int fast = n;
        int slow = n;
        do {
            fast = nums[fast]-1;
            fast = nums[fast]-1;
            slow = nums[slow]-1;
        } while (fast!=slow);
        
        fast = n;
        while (fast!=slow) {
            fast = nums[fast]-1;
            slow = nums[slow]-1;
        }
        
        return slow+1;
    }
}
