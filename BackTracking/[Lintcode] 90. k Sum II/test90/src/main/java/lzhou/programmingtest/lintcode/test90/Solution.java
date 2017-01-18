package lzhou.programmingtest.lintcode.test90;

import java.util.*;

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<Integer> selected = new ArrayList<Integer>(k);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        return kSumIIHelper(A, 0, k, target, selected, results);
    }
    
    private ArrayList<ArrayList<Integer>> kSumIIHelper(int[] A, int start, int k, int target, ArrayList<Integer> selected, ArrayList<ArrayList<Integer>> results) {
        if (k==0 && target==0) {
            results.add(new ArrayList<Integer>(selected));
            return results;
        }
        if (k==0 || target==0) {
            return results;
        }
        for (int i=start; i<A.length-k+1; ++i) {
            selected.add(A[i]);
            
            kSumIIHelper(A, i+1,  k-1, target-A[i], selected, results);
            
            selected.remove(selected.size()-1);
        }
        return results;
    }
}
