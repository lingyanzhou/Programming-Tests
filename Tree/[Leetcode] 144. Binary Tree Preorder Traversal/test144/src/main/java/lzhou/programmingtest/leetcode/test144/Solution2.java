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
public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            while (n!=null) {
                ret.add(n.val);
                stack.push(n.right);
                n = n.left;
            }
        }

        return ret;
    }
}
