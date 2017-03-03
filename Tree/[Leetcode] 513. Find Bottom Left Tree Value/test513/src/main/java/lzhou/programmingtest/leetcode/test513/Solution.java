package lzhou.programmingtest.leetcode.test513;

import java.util.*;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValueHelper(root, 0)[1];
    }
    
    private int[] findBottomLeftValueHelper(TreeNode root, int depth) {
        if (root==null) {
            return null;
        }
        int[] ret = {depth, root.val};
        if (root.left!=null) {
            int[] tmp = findBottomLeftValueHelper(root.left, depth+1);
            if (ret[0]<tmp[0]) {
                ret = tmp;
            }
        }
        if (root.right!=null) {
            int[] tmp = findBottomLeftValueHelper(root.right, depth+1);
            if (ret[0]<tmp[0]) {
                ret = tmp;
            }
        }
        return ret;
    }
}
