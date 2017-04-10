package lzhou.programmingtest.leetcode.test298;

import java.util.*;

public class Solution 
{
    public int longestConsecutive(TreeNode root) {
        return Math.max(longestConsecutiveRoot(root), longestConsecutiveNonRoot(root));
    }

    private int longestConsecutiveRoot(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int result = 0;
        if (root.left != null && root.val+1==root.left.val) {
            result = longestConsecutiveRoot(root.left);
        }
        if (root.right != null && root.val+1==root.right.val) {
            result = Math.max(result, longestConsecutiveRoot(root.right));
        }

        return result+1;
    }

    private int longestConsecutiveNonRoot(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if (root.left == null && root.right==null) {
            return 0;
        }
        int result = 0;
        if (root.left != null) {
            result = longestConsecutive(root.left);
        }
        if (root.right != null) {
            result = Math.max(result, longestConsecutive(root.right));
        }
        return result;
    }
}
