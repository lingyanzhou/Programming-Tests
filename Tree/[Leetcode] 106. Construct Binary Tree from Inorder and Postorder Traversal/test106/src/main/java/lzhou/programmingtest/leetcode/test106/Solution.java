package lzhou.programmingtest.leetcode.test106;

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
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n==0) {
            return null;
        }
        
        Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>(inorder.length);
        for (int i=0; i<inorder.length; ++i) {
            inorderMap.put(Integer.valueOf(inorder[i]), Integer.valueOf(i));
        }
        
        return buildTree(inorder, 0, n, postorder, 0, n, inorderMap);
    }
    
    public TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd, Map<Integer, Integer> inorderMap) {
        if (inorderEnd==inorderStart) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderEnd-1]);
        int rootInorderIndex = inorderMap.get(Integer.valueOf(postorder[postorderEnd-1])).intValue();
        root.left = buildTree(inorder, inorderStart, rootInorderIndex, postorder, postorderStart, postorderStart+rootInorderIndex-inorderStart, inorderMap);
        root.right = buildTree(inorder, rootInorderIndex+1, inorderEnd, postorder, postorderEnd-inorderEnd+rootInorderIndex, postorderEnd-1, inorderMap);
        return root;
    }
}
