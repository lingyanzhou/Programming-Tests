package lzhou.programmingtest.leetcode.test235;

import java.util.*;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return null;
        }
        if (p==null || q==null) {
            return root;
        }
        if (p.val>q.val) {
            TreeNode tmp = p;
            p=q;
            q=tmp;
        }
        if (p.val<=root.val && q.val>=root.val) {
            return root;
        }
        if (q.val<root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }
}
