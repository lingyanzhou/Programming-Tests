package lzhou.programmingtest.leetcode.test144;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();

        if (root==null) {
            return ret;
        }
        
        ret.add(root.val);

        if (root.left!=null) {
            ret.addAll(preorderTraversal(root.left));
        }

        if (root.right!=null) {
            ret.addAll(preorderTraversal(root.right));
        }

        return ret;
    }
}
