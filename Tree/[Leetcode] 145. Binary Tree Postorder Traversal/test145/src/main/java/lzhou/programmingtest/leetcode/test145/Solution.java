package lzhou.programmingtest.leetcode.test145;

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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();

        if (root==null) {
            return ret;
        }
        
        if (root.left!=null) {
            ret.addAll(postorderTraversal(root.left));
        }

        if (root.right!=null) {
            ret.addAll(postorderTraversal(root.right));
        }
        ret.add(root.val);

        return ret;
    }
}
