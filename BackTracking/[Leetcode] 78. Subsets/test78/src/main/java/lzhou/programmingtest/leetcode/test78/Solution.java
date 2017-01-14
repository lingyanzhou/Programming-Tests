package lzhou.programmingtest.leetcode.test78;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        return subsetsHelper(nums, 0, results, new ArrayList<Integer>());
    }
    
    private List<List<Integer>> subsetsHelper(int[] nums, int start, List<List<Integer>> results, List<Integer> partial) {
        if (start==nums.length) {
            results.add(new ArrayList<Integer>(partial));
            return results;
        }
        subsetsHelper(nums, start+1, results, partial);
        partial.add(nums[start]);
        subsetsHelper(nums, start+1, results, partial);
        partial.remove(partial.size()-1);
        return results;
    }
}
