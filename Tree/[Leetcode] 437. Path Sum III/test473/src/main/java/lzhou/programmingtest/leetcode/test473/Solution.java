package lzhou.programmingtest.leetcode.test473;

import java.util.*;

/**
 * Hash table solution
 * 
 *   * During DFS, use a hash table to remember all possible sums from root to a previous node. 
 *   * Use a variable (```curSum```) to remember the sum from root to current node . 
 *   * Then some path from a previous node to the current node is the difference between the current sum and an entry in the map.
 *   * Given the target sum, we can query those paths as table[curSum-target]
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prevSum = new HashMap<Integer, Integer>();
        prevSum.put(0, 1);
        return pathSumHelper(root, sum, 0, prevSum);
    }
    private int pathSumHelper(TreeNode root, int sum, int curSum, Map<Integer, Integer> prevSum) {
        if (root==null) {
            return 0;
        }
        curSum+=root.val;
        int ret = 0;
        if (prevSum.containsKey(curSum-sum)) {
            ret = prevSum.get(curSum-sum);
        }
        if (prevSum.containsKey(curSum)) {
            prevSum.put(curSum, 1+prevSum.get(curSum));
        } else {
            prevSum.put(curSum, 1);
        }
        ret+=pathSumHelper(root.left, sum, curSum, prevSum);
        ret+=pathSumHelper(root.right, sum, curSum, prevSum);
        prevSum.put(curSum, prevSum.get(curSum)-1);
        return ret;
    }
}
