package lzhou.programmingtest.leetcode.test39;

import java.util.*;

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
        // write your code here
        if (target<=0) {
            return new ArrayList<List<Integer>>();
        }
        
        Arrays.sort(candidates);
        candidates = removeDuplicateFromSorted(candidates);

        return combinationSumHelper(candidates, 0, target, new ArrayList<List<Integer>>(), new ArrayList<Integer>());
    }
    
    private List<List<Integer>> combinationSumHelper(int[] candidates, int start, int target, List<List<Integer>> results, List<Integer> partial) {
        // write your code here
        if (target==0) {
            results.add(new ArrayList<Integer>(partial));
            return results;
        }
        if (target<0 || start>=candidates.length) {
            return results;
        }

        int count = 0;
        while (target>=0) {
            partial.add(candidates[start]);
            target-=candidates[start];
            count+=1;
        }

        while (count>0) {
            partial.remove(partial.size()-1);
            target+=candidates[start];
            count-=1;
            combinationSumHelper(candidates, start+1, target, results, partial);
        }
        return results;
    }

    private int[] removeDuplicateFromSorted(int[] a) {
        if (a.length<=1) {
            return a;
        }
        int[] buff = new int[a.length];
        buff[0] = a[0];
        int len=1;
        for (int i=1; i<a.length; ++i) {
            if (a[i]!=a[i-1]) {
                buff[len]=a[i];
                len+=1;
            }
        }
        int[] ret = new int[len];
        System.arraycopy(buff, 0, ret, 0, len);
        return ret;
    }
}
