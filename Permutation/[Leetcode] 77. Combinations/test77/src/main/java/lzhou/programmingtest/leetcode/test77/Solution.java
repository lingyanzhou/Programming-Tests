package lzhou.programmingtest.leetcode.test77;

import java.util.*;

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		return combineHelper(1, n, k, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }
    
    private List<List<Integer>> combineHelper(int m, int n, int k, List<Integer> partial, List<List<Integer>> results) {
		// write your code here
		if (k==1) {
		    for (int i=m; i<=n; ++i) {
    		    partial.add(i);
    		    results.add(new ArrayList<Integer>(partial));
    		    partial.remove(partial.size()-1);
    		}
		} else {
    		for (int i=m; i<=n-k+1; ++i) {
    		    partial.add(i);
        		combineHelper(i+1, n, k-1, partial, results);
    		    partial.remove(partial.size()-1);
    		}
		}
		return results;
    }
}
