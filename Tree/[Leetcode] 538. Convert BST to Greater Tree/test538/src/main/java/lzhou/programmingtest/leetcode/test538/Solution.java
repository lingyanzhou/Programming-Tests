package lzhou.programmingtest.leetcode.test538;

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
    public TreeNode convertBST(TreeNode root) {
        if (root==null) {
            return null;
        }
        int largerSum = 0;
        
        TreeNode fakeRoot = new TreeNode(0);
        fakeRoot.right=root;
        TreeNode cur = fakeRoot;
        boolean goleft = false;
        Set<TreeNode> threadedLeftPtrs = new HashSet<TreeNode>();
        do {
            if (!goleft) {
                cur = pretraverse(cur, threadedLeftPtrs);
            }
            
            largerSum += cur.val;
            cur.val = largerSum;
            
            TreeNode tmp = cur;
            cur=cur.left;
            goleft=false;
            if (threadedLeftPtrs.contains(tmp)) {
                threadedLeftPtrs.remove(tmp);
                tmp.left = null;
                goleft=true;
            }
        } while (cur!=fakeRoot);
        
        return root;
    }
    
    private TreeNode pretraverse(TreeNode cur, Set<TreeNode> threadedLeftPtrs) {
        TreeNode prev = cur;
        while (cur.right!=null) {
            cur = cur.right;
            TreeNode tmp = cur;
            while (tmp.left!=null) {
                tmp=tmp.left;
            }
            tmp.left=prev;
            threadedLeftPtrs.add(tmp);
            prev=cur;
        }
        return cur;
    }
}
