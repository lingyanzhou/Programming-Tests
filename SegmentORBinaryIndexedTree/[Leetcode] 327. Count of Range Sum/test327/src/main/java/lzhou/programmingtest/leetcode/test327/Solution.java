package lzhou.programmingtest.leetcode.test327;

import java.util.*;

/**
 * TreeMap solution
 * Slightly better than O(n^2), Worst O(n^2)
 *
 *   * The treemap's keys are the sums of previous subarray starting from index 0; the values are the occurances.
 *   * ```sum``` is the sum from index 0 to the current index.
 *   * Then the sum of any subarray that ends at the current index can be found as ```sum-map.key```
 *   * We count all the occurances in the tree where ```lower<=sum-map.key<=upper```
 */
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Integer> tree = new TreeMap<Long, Integer>();
        tree.put(0L, 1);
        long sum = 0;
        int ret = 0;
        for (int n:nums) {
            sum+=n;
            Map<Long, Integer> subMap = tree.headMap(sum-lower+1).tailMap(sum-upper);
            for (int v:subMap.values()) {
                ret+=v;
            }
            int count = 1;
            if (tree.containsKey(sum)) {
                count+=tree.get(sum);
            }
            tree.put(sum, count);
        }
        
        return ret;
    }
}
