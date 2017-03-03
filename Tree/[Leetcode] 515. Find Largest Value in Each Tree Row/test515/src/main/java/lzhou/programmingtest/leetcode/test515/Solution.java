package lzhou.programmingtest.leetcode.test515;

import java.util.*;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> results = new ArrayList<Integer> ();
        largestValuesHelper(root, 0, results);
        return results;
    }
    
    private void largestValuesHelper(TreeNode root, int level, List<Integer> results) {
        if (root==null) {
            return;
        }
        if (level==results.size()) {
            results.add(root.val);
        } else if (root.val>results.get(level)) {
            results.set(level, root.val);
        }
        largestValuesHelper(root.left, level+1, results);
        largestValuesHelper(root.right, level+1, results);
    }
}
