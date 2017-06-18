package lzhou.programmingtest.leetcode.test623;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        TreeNode fakeroot = new TreeNode(0);
        fakeroot.left = addOneRowHelper(root, v, d, true);
        return fakeroot.left;
    }
    private TreeNode addOneRowHelper(TreeNode root, int v, int d, boolean isLeft) {
        if (d==1) {
            if (isLeft) {
                TreeNode n = new TreeNode(v);
                n.left = root;
                return n;
            } else {
                TreeNode n = new TreeNode(v);
                n.right = root;
                return n;
            }
        } else if (root==null){
            return null;
        } else {
            root.left = addOneRowHelper(root.left, v, d-1, true);
            root.right = addOneRowHelper(root.right, v, d-1, false);
            return root;
        }
    }
}
