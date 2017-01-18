package lzhou.programmingtest.leetcode.test105;

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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length);
    }
    
    
    private TreeNode buildTreeHelper(int[] preorder, int head, int[] inorder, int start, int end) {
        // write your code here
        if (start==end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[head]);
        
        int i=0;
        for (; i<inorder.length; ++i) {
            if (inorder[i]==preorder[head]) {
                break;
            }
        }
        
        root.left = buildTreeHelper(preorder, head+1, inorder, start, i);
        root.right = buildTreeHelper(preorder, head+1+i-start, inorder, i+1, end);
        
        return root;
    }
}
