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
public class Solution3 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();

        //cur pointer indicates we visit the node the first time.
        //when we visit a node by poping the stack we are visiting it the second time.
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        
        while (!stack.isEmpty() || cur!=null) {
            if (cur!=null) {
                while (cur!=null) {
                    stack.push(cur);
                    cur=cur.left;
                }
            } else {
                TreeNode n = stack.pop();
                ret.add(n.val);
                if (n.right!=null) {
                    cur = n.right;
                }
            }
        }

        return ret;
    }
}
