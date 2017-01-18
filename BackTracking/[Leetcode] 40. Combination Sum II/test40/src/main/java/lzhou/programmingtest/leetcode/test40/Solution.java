package lzhou.programmingtest.leetcode.test40;

import java.util.*;

/*
 * Recursion
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2Helper(candidates, 0, target, new ArrayList<List<Integer>>(), new ArrayList<Integer>());
    }
    
    public List<List<Integer>> combinationSum2Helper(int[] candidates, int start, int target, List<List<Integer>> results, List<Integer> partial) {
        if (start==candidates.length || target<=0) {
            if (target==0) {
                results.add(new ArrayList<Integer>(partial));
            }
            return results;
        }
        for (int i=start; i<candidates.length; ++i) {
            if (i>start && candidates[i]==candidates[i-1]) {
                continue;
            }
            partial.add(candidates[i]);
            combinationSum2Helper(candidates, i+1, target-candidates[i], results, partial);
            partial.remove(partial.size()-1);
        }
        return results;
    }
}
