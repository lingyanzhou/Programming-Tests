package lzhou.programmingtest.leetcode.test107;

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
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>>  levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Queue<TreeNode> level = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        
        if (root==null) {
            return ret;
        }
        
        level.offer(root);
        while (!level.isEmpty()) {
            List<Integer> tmplist = new ArrayList<Integer>(level.size());
            for (TreeNode n: level) {
                tmplist.add(n.val);
            }
            ret.add(0, tmplist);
            
            for (TreeNode n: level) {
                if (n.left!=null) {
                    nextLevel.offer(n.left);
                }
                if (n.right!=null) {
                    nextLevel.offer(n.right);
                }
            }

            Queue<TreeNode> tmpLevel = level;
            level = nextLevel;
            nextLevel = tmpLevel;
            nextLevel.clear();
        }  
        
        return ret;
    }
}
