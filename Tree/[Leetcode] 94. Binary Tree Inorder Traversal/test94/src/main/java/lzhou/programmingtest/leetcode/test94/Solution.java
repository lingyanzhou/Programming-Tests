package lzhou.programmingtest.leetcode.test94;

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root==null) {
            return ret;
        }
        
        if (root.left!=null)
            ret.addAll(inorderTraversal(root.left));
        ret.add(root.val);
        if (root.right!=null)
            ret.addAll(inorderTraversal(root.right));
        return ret;
    }
}
