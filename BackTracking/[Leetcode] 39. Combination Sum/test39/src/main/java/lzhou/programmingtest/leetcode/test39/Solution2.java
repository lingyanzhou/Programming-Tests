package lzhou.programmingtest.leetcode.test39;

import java.util.*;

/*
 * Recursion
 */
/*
 * Recursion
 */
public class Solution2 {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSumHelper(candidates, 0, target, new ArrayList<List<Integer>>(), new ArrayList<Integer>());
    }
    
    public List<List<Integer>> combinationSumHelper(int[] candidates, int start, int target, List<List<Integer>> results, List<Integer> partial) {
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
            combinationSumHelper(candidates, i, target-candidates[i], results, partial);
            partial.remove(partial.size()-1);
        }
        return results;
    }
}
