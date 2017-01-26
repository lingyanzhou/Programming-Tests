package lzhou.programmingtest.leetcode.test473;

import java.util.*;

/**
 * Naive DFS
 *   
 *   * Recursion: pathSum(root, sum) = pathSum(left, sum)
 *                                     + pathSum(right, sum)
 *                                     + pathSumAtRoot(left, sum-root.val)
 *                                     + pathSumAtRoot(right, sum-root.val)
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
        int ret = 0;
        if (root==null) {
            return ret;
        }
        if (sum==root.val) {
            ret+=1;
        }
        ret+= pathSumAtRoot(root.left, sum-root.val);
        ret+= pathSum(root.left, sum);
        ret+= pathSumAtRoot(root.right, sum-root.val);
        ret+= pathSum(root.right, sum);
        return ret;
    }
    private int pathSumAtRoot(TreeNode root, int sum) {
        int ret = 0;
        if (root==null) {
            return ret;
        }
        if (sum==root.val) {
            ret+=1;
        }
        ret+= pathSumAtRoot(root.left, sum-root.val);
        ret+= pathSumAtRoot(root.right, sum-root.val);
        return ret;
    }
}
