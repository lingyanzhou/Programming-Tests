package lzhou.programmingtest.leetcode.test236;

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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        State state = lowestCommonAncestorHelper(root, A, B);
        return state.lca;
    }
    
    public State lowestCommonAncestorHelper(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root==null) {
            return new State();
        }
        
        State left = lowestCommonAncestorHelper(root.left, A, B);
        if (left.lca!=null) {
            return left;
        }
        
        State right = lowestCommonAncestorHelper(root.right, A, B);
        if (right.lca!=null) {
            return right;
        }
        
        State ret = new State();
        ret.AFound = (root==A || left.AFound || right.AFound);
        ret.BFound = (root==B || left.BFound || right.BFound);
        if (ret.AFound && ret.BFound) {
            ret.lca = root;
        }
        
        return ret;
    }
    
    static class State {
        TreeNode lca = null;
        boolean AFound = false;
        boolean BFound = false;
    }
}
