package lzhou.programmingtest.leetcode.test90;

import java.util.*;

/*
 * Recursive implementation
 *
 * 1. Count current numbers occurence.
 * 2. From 0..duplication, we add the number to the partial result, and start the next recursion.
 * 3. The next recursion will start at the next different number.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums.length==0) {
            return results;
        }
        Arrays.sort(nums);
        
        subsetsWithDup(nums, nums.length, new ArrayList<Integer>(), results);
        
        return results;
    }
    
    public void subsetsWithDup(int[] nums, int end, List<Integer> partialResult, List<List<Integer>> results) {
        if (end==0) {
            results.add(new ArrayList(partialResult));
            return;
        }
        for (int i=end-1; i>=0;) {
            int j=i;
            while (j>=0 && nums[i]==nums[j]) {
                j-=1;
            }
            int repeat = i-j;
            
            for (int k=0; k<repeat; ++k) {
                partialResult.add(Integer.valueOf(nums[i]));
                subsetsWithDup(nums, j+1, partialResult, results);
            }
            for (int k=0; k<repeat; ++k) {
                partialResult.remove(partialResult.size()-1);
            }
            i=j;
        }
        results.add(new ArrayList(partialResult));
    }
}
