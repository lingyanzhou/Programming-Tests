package lzhou.programmingtest.leetcode.test337;

import java.util.*;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

/*
 * Dp solution.
 * Only need to visit each node once.
 *
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int rob(TreeNode root) {
        // write your code here
        
        return houseRobber3Help(root).getMax();
    }
    
    public TreeResult houseRobber3Help(TreeNode root) {
        // write your code here
        if (root==null) {
            return new TreeResult(0,0);
        }
        if (root.right==null && root.left==null) {
            return new TreeResult(root.val,0);
        }
        TreeResult left = houseRobber3Help(root.left);
        TreeResult right = houseRobber3Help(root.right);
        
        int withRootMax = root.val+left.withoutRootMax+right.withoutRootMax;
        int withoutRootMax = left.withRootMax+right.withRootMax;
        withoutRootMax = Math.max(withoutRootMax, left.withoutRootMax+right.withRootMax);
        withoutRootMax = Math.max(withoutRootMax, left.withRootMax+right.withoutRootMax);
        withoutRootMax = Math.max(withoutRootMax, left.withoutRootMax+right.withoutRootMax);
        return new TreeResult(withRootMax, withoutRootMax);
    }
    
    static class TreeResult {
        public int withRootMax = 0;
        public int withoutRootMax = 0;
        
        public TreeResult(int withRootMax, int withoutRootMax) {
            this.withRootMax = withRootMax;
            this.withoutRootMax = withoutRootMax;
        }
        
        public int getMax() {
            return Math.max(withRootMax, withoutRootMax);
        }
    }
}
