package lzhou.programmingtest.leetcode.test473;

import java.util.*;

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
        return pathSumHelper(root, sum, new int[1001], 0);
    }
    
    private int pathSumHelper(TreeNode root, int sum, int[] prevPathSum, int validPrevPathSumLength) {
        if (root==null) return 0;
        int ret = 0;
        for (int i=0; i<=validPrevPathSumLength; ++i) {
            prevPathSum[i]+=root.val;
            if (prevPathSum[i]==sum) {
                ret+=1;
            }
        }
        ret+= pathSumHelper(root.left, sum, prevPathSum, validPrevPathSumLength+1);
        ret+= pathSumHelper(root.right, sum, prevPathSum, validPrevPathSumLength+1);
        
        for (int i=0; i<=validPrevPathSumLength; ++i) {
            prevPathSum[i]-=root.val;
        }
        
        return ret;
    }
}
