package lzhou.programmingtest.leetcode.test124;

import java.util.*;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root==null) {
            return 0;
        }
        Pair p = maxPathSumHelper(root);
        
        return (int)p.v2;
    }
    
    public Pair maxPathSumHelper(TreeNode root) {
        // write your code here
        if (root==null) {
            return null;
        }
        Pair ret = new Pair();
        Pair leftResult = maxPathSumHelper(root.left);
        Pair rightResult = maxPathSumHelper(root.right);
        if (leftResult==null && rightResult==null) {
            ret.v1 = root.val;
            ret.v2 = root.val;
        } else if (leftResult==null) {
            ret.v1 = root.val+rightResult.v1;
            ret.v1 = Math.max(root.val, ret.v1);
            ret.v2 = Math.max(ret.v1, rightResult.v2);
        } else if (rightResult==null) {
            ret.v1 = root.val+leftResult.v1;
            ret.v1 = Math.max(root.val, ret.v1);
            ret.v2 = Math.max(ret.v1, leftResult.v2);
        } else {
            ret.v1 = root.val+Math.max(leftResult.v1, rightResult.v1);
            ret.v1 = Math.max(root.val, ret.v1);
            ret.v2 = Math.max(ret.v1, leftResult.v2);
            ret.v2 = Math.max(ret.v2, rightResult.v2);
            ret.v2 = Math.max(ret.v2, root.val+leftResult.v1+rightResult.v1);
        }
        return ret;
    }
}

class Pair {
    long v1;
    long v2;
    Pair() {
        this(0,0);
    }
    Pair(long v1, long v2) {
        this.v1=v1;
        this.v2=v2;
    }
    
    long getMax() {
        return Math.max(v1, v2);
    }
}
