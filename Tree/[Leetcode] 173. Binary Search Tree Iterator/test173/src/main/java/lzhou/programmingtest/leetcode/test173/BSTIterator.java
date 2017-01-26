package lzhou.programmingtest.leetcode.test173;

import java.util.*;

/**
 * Morris Traversal
 * Ref:http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 * Space: O(1)
 *
 *   1. For each node we meet, we try to find its predecessor (rightmost node in its left subtree) if it has  one.
 *   2. If it is the first time, the predecessor's right pointer is null. We connect it to the current node. Then move the node left one step. Repeat 1-2.
 *   3. If it is the second time, the predecessor's right pointer is not null. We disconnect the pointer.
 *   4. Print the current node value, and move to its right. Repeat 1-4.
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    private TreeNode next;
    private TreeNode predecessor;
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        // write your code here
        next=root;
        predecessor=null;
        if (next==null) {
            return;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return next != null;
    }
    
    //@return: return next node
    public int next() {
        // write your code here
        if (!hasNext()) {
            return -1;
        }
        if (next.left!=null) {
            preTraverse();
        }
        int ret = next.val;
        next = next.right;
        return ret;
    }
    
    private void preTraverse() {
        while (next!=null && next.left!=null) {
            TreeNode successor = next;
            next = next.left;
            predecessor = next;
            while (predecessor.right!=null && predecessor.right!=successor) {
                predecessor = predecessor.right;
            }
            if (predecessor.right==successor) {
                predecessor.right=null;
                next = successor;
                return;
            }
            predecessor.right = successor;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
