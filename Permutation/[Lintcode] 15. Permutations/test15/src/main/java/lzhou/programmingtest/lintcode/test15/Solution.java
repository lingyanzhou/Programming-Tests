package lzhou.programmingtest.lintcode.test15;

import java.util.*;

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
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
            int tmp =nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            permuteHelper(Arrays.copyOf(nums, nums.length), start+1, results);
        }
        return results;
    }
}
