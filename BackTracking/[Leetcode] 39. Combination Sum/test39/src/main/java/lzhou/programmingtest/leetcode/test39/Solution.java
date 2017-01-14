package lzhou.programmingtest.leetcode.test39;

import java.util.*;

/*
 * DP solution
 * For this problem dp does not yield better performance. Simple back tracking terminates equally fast.
 */
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        if (target<=0) {
            return new ArrayList<List<Integer>>();
        }
        
        Arrays.sort(candidates);
        
        List<List<List<Integer>>> dp = new ArrayList<List<List<Integer>>>(target);
        for (int i=0; i<=target; ++i) {
            dp.add(new ArrayList<List<Integer>>());
        }
        dp.get(0).add(new ArrayList<Integer>());
        
        for (int i=0; i<candidates.length; ++i) {
            if (i>0 && candidates[i]==candidates[i-1]) {
                continue;
            }
            for (int j=0; j<=target-candidates[i]; ++j) {
                if (dp.get(j).size()!=0) {
                    for (List<Integer> l: dp.get(j)) {
                        List<Integer> cpy = new ArrayList<Integer>(l);
                        cpy.add(candidates[i]);
                        dp.get(j+candidates[i]).add(cpy);
                    }
                }
            }
        }
        return dp.get(target);
    }
}
