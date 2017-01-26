package lzhou.programmingtest.leetcode.test95;

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
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        if (n==0) {
            return new ArrayList<TreeNode>();
        }
        List<Integer> notUsed = new ArrayList<Integer>(n);
        for (int i=1; i<=n; ++i) {
            notUsed.add(i);
        }
        return generateTreesHelper(notUsed);
    }
    
    public List<TreeNode> generateTreesHelper(List<Integer> notUsed) {
        // write your code here
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if (notUsed.size()==0) {
            ret.add(null);
            return ret;
        }
        for (int i=0; i<notUsed.size(); ++i) {
            List<TreeNode> leftlist = generateTreesHelper(notUsed.subList(0, i));
            List<TreeNode> rightlist = generateTreesHelper(notUsed.subList(i+1, notUsed.size()));
            for (TreeNode l: leftlist) {
                for (TreeNode r: rightlist) {
                    TreeNode root = new TreeNode(notUsed.get(i));
                    root.left = l;
                    root.right = r;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
