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
public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<NodeState> stack = new Stack<NodeState>();
        
        stack.push(new NodeState(root));
        while (!stack.isEmpty()) {
            NodeState ns = stack.peek();
            TreeNode n = ns.node;
            if (ns.state==0) {
                if (n.left!=null)
                    stack.push(new NodeState(n.left));
                ns.state=1;
            } else if (ns.state==1) {
                ret.add(ns.node.val);
                stack.pop();
                if (n.right!=null)
                    stack.push(new NodeState(n.right));
            }
        }

        return ret;
    }

    static class NodeState {
        TreeNode node;
        int state;
        NodeState(TreeNode node) {
            this.node = node;
            state = 0;
        }
    }
}
