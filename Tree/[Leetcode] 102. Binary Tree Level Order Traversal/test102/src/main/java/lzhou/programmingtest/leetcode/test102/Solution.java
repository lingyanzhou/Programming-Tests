package lzhou.programmingtest.leetcode.test102;

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
 
/*
 * Challenge: Using only one queue.
 *
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>>  levelOrder(TreeNode root) {
        // write your code here
        if (root==null) {
            return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> oneLine = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        while (queue.size()>1) {
            TreeNode cur = queue.poll();
            if (cur==null) {
                ret.add(oneLine);
                oneLine = new ArrayList<Integer>();
                queue.offer(null);
                continue;
            }
            if (cur.left!=null) {
                queue.offer(cur.left);
            }
            if (cur.right!=null) {
                queue.offer(cur.right);
            }
            
            oneLine.add(cur.val);
        }
        ret.add(oneLine);
        
        return ret;
    }
}
