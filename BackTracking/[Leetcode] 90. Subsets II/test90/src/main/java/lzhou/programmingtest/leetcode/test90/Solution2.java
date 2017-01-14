package lzhou.programmingtest.leetcode.test90;

import java.util.*;

/*
 * Iterative implementation
 *
 * 1. With no duplication, adding a number will double the set, each new combination being created by appending the number to a combination already in the set.
 * 2. If the number is a duplication, then only the combinations with the last element equaling to the number are used. Or we can keep track of how many items are created for the previous number.
 */
public class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        results.add(new ArrayList<Integer>());
        if (nums.length==0) {
            return results;
        }
        Arrays.sort(nums);
        int lastStart = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i>0 && nums[i]==nums[i-1]) {
                int end = results.size();
                for (int j=lastStart; j<end; ++j) {
                    List<Integer> l = new ArrayList<Integer>(results.get(j));
                    l.add(nums[i]);
                    results.add(l);
                }
                lastStart=end;
            } else {
                int end = results.size();
                for (int j=0; j<end; ++j) {
                    List<Integer> l = new ArrayList<Integer>(results.get(j));
                    l.add(nums[i]);
                    results.add(l);
                }
                lastStart=end;
            }
        }
        
        return results;
    }
}
