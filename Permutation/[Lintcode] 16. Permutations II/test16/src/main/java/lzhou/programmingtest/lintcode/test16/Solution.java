package lzhou.programmingtest.lintcode.test16;

import java.util.*;

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        return permuteHelper(nums, 0, results);
    }
    
    
    public List<List<Integer>> permuteHelper(int[] nums, int start, List<List<Integer>> results) {
        // write your code here
        if (start==nums.length) {
            List<Integer> l = new ArrayList<Integer>(nums.length);
            for (int i: nums) {
                l.add(i);
            }
            results.add(l);
            return results;
        }
        
        for (int i=start; i<nums.length; ++i) {
            if (i>start && nums[i]==nums[start]) {
                continue;
            }
            int tmp =nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            permuteHelper(Arrays.copyOf(nums, nums.length), start+1, results);
        }
        return results;
    }
}
