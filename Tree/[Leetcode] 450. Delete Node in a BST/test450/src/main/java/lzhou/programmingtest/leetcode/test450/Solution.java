package lzhou.programmingtest.leetcode.test450;

import java.util.*;

/**
 * Idea:
 *   1. Find the node first.
 *   2. Find its predecessor.
 *   3.1 The predecessor is a left child of its parent. Simply replace the target with its predecessor and connect predecessors right pointer to the target's right pointer.
 *   3.2 The predecessor is a right child of its parent.
 *   3.2.1 If it is a left node, swap it with the target node. Connect its left, right pointers to those of the target.
 *   3.2.2 Otherwise, connect its parent's right pointer to its left subtree, and do 3.2.1.
 */

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
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode deleteNode(TreeNode root, int value) {
        // write your code here
        if (root==null) {
            return null;
        }
        if (root.val==value) {
            TreeNode predecessor = removePredecessor(root);
            if (predecessor==null) {
                return root.right;
            } else {
                predecessor.right = root.right;
                if (predecessor.left==null)
                predecessor.left = root.left;
                return predecessor;
            }
        } else if (root.val>value) {
            root.left = deleteNode(root.left, value);
        } else {
            root.right = deleteNode(root.right, value);
        }
        return root;
    }
    
    private TreeNode removePredecessor(TreeNode root) {
        if (root==null || root.left==null) {
            return null;
        }
        TreeNode prev = root;
        TreeNode cur = root.left;
        while (cur.right!=null) {
            prev = cur;
            cur = cur.right;
        }
        if (prev.right==cur) {
            prev.right = cur.left;
        } else {
            prev.left = cur.left;
        }
        cur.left = null;
        return cur;
    }
}
