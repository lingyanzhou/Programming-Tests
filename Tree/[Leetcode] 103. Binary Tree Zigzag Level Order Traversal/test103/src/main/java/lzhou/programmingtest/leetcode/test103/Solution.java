package lzhou.programmingtest.leetcode.test103;

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
    public List<List<Integer>>  zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Stack<TreeNode> level = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        
        if (root==null) {
            return ret;
        }
        
        level.push(root);
        boolean direction = true;
        while (!level.isEmpty()) {
            List<Integer> tmplist = new ArrayList<Integer>(level.size());
            
            while (!level.isEmpty()) {
                TreeNode n = level.pop();
                tmplist.add(n.val);
                
                if (direction) {
                    if (n.left!=null) {
                        nextLevel.push(n.left);
                    }
                    if (n.right!=null) {
                        nextLevel.push(n.right);
                    }
                } else {
                    if (n.right!=null) {
                        nextLevel.push(n.right);
                    }
                    if (n.left!=null) {
                        nextLevel.push(n.left);
                    }
                }
            }
            
            ret.add(tmplist);

            direction = !direction;
            Stack<TreeNode> tmpLevel = level;
            level = nextLevel;
            nextLevel = tmpLevel;
            nextLevel.clear();
        }  
        
        return ret;
    }
}
