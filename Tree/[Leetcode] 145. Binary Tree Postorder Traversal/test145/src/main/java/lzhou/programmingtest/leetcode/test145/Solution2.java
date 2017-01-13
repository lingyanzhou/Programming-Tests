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
public class Solution2 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;
        TreeNode prevPoped= null;

        while (!stack.isEmpty() || cur!=null) {
            if (cur!=null) {
                while (cur!=null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                prevPoped= null;
            } else if(prevPoped!=stack.peek().right && stack.peek().right!=null) {
                TreeNode n = stack.peek();
                cur = n.right;
            } else {
                prevPoped =stack.pop();
                ret.add(prevPoped.val);
            }
        }

        return ret;
    }
}
