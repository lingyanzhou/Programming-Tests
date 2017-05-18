package lzhou.programmingtest.leetcode.test416;

import java.util.*;

/**
 * DP: naive
 */
public class Solution1 {
    public boolean canPartition(int[] nums) {
        Set<Integer> current = new HashSet<Integer>();
        Set<Integer> next = new HashSet<Integer>();
        current.add(0);
        for (int n: nums) {
            for (Integer c: current) {
                next.add(Math.abs(c-n));
                next.add(c+n);
            }
            
            Set<Integer> tmp = current;
            current = next;
            next = tmp;
            next.clear();
        }
        
        return current.contains(0);
    }
}
