package lzhou.programmingtest.leetcode.test549;

import java.util.*;

public class Solution 
{
    public int longestConsecutiveII(TreeNode root) {
        return Math.max(longestConsecutiveIIRootInc(root)+longestConsecutiveIIRootDec(root)-1, longestConsecutiveIINonRoot(root));
    }

    private int longestConsecutiveIIRootInc(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int result = 0;
        if (root.left != null && root.val+1==root.left.val) {
            result = longestConsecutiveIIRootInc(root.left);
        }
        if (root.right != null && root.val+1==root.right.val) {
            result = Math.max(result, longestConsecutiveIIRootInc(root.right));
        }

        return result+1;
    }

    private int longestConsecutiveIIRootDec(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int result = 0;
        if (root.left != null && root.val-1==root.left.val) {
            result = longestConsecutiveIIRootDec(root.left);
        }
        if (root.right != null && root.val-1==root.right.val) {
            result = Math.max(result, longestConsecutiveIIRootDec(root.right));
        }

        return result+1;
    }

    private int longestConsecutiveIINonRoot(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if (root.left == null && root.right==null) {
            return 0;
        }
        int result = 0;
        if (root.left != null) {
            result = longestConsecutiveII(root.left);
        }
        if (root.right != null) {
            result = Math.max(result, longestConsecutiveII(root.right));
        }
        return result;
    }
}
