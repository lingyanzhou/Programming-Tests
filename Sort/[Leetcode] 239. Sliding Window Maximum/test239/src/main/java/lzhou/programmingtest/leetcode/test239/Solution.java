package lzhou.programmingtest.leetcode.test239;

import java.util.*;


/*
 * Deque solution
 * Idea:
 *   1. Keep an ordered deque, with its first element being the maximum.
 *   2. Push new elements to the end, removing tailing elements that is smaller. Older elements has a lower index than the new one, and they are not interesting if their value if smaller.
 *   3. In this way, we keep the sliding window maximum at the head, and candidates at the tail in descending order.
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k<=1) {
            return nums;
        }
        int[] ret = new int[nums.length-k+1];
        Deque<Integer> maxQueue = new LinkedList<Integer>();
        for (int i=0; i<k;++i) {
            while (maxQueue.size()>0 && nums[maxQueue.peekLast()]<nums[i]) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(i);
        }
        
        ret[0] = nums[maxQueue.peekFirst()];
        
        for (int i=k; i<nums.length; ++i) {
            if (maxQueue.peekFirst()==i-k) {
                maxQueue.removeFirst();
            }
            while (maxQueue.size()>0 && nums[maxQueue.peekLast()]<nums[i]) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(i);
            ret[i-k+1] = nums[maxQueue.peekFirst()];
        }
        
        return ret;
    }
}
