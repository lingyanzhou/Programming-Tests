package lzhou.programmingtest.leetcode.test216;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3Helper(k,1, n, new ArrayList<List<Integer>>(), new ArrayList<Integer>());
    }
    public List<List<Integer>> combinationSum3Helper(int k, int j, int n, List<List<Integer>> result, List<Integer> partial) {
        if (partial.size()==k && n==0) {
            result.add(new ArrayList<Integer>(partial));
            return result;
        }
        if (partial.size()==k || n<0) {
            return result;
        }
        for (int i=j; i<=9; ++i) {
            partial.add(i);
            combinationSum3Helper(k, i+1, n-i, result, partial);
            partial.remove(partial.size()-1);
        }
        
        return result;
    }
}
