package lzhou.programmingtest.lintcode.test178;

import java.util.*;

public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code 
        
        HashMap<Integer, UnionFindNode> map = new HashMap<Integer, UnionFindNode>();
        
        for (int i=0; i<n; ++i) {
            map.put(i, new UnionFindNode(i));
        }
        
        for (int[] e: edges) {
            if (!map.get(e[0]).union(map.get(e[1]))) {
                    //System.out.println("circle detected");
                    //System.out.println(Arrays.toString(e));
                return false;
            }
        }
        
        UnionFindNode root = null;
        for (UnionFindNode u: map.values()) {
            if (root==null) {
                root=u.parent;
            } else {
                if (u.parent!=root) {
                    //System.out.println("u is isolated");
                    //System.out.println(root.label);
                    //System.out.println(u.label);
                    return false;
                }
            }
        }
        return true;
    }
    
    static class UnionFindNode {
        UnionFindNode parent;
        HashMap<Integer, UnionFindNode> children;
        int label;
        public UnionFindNode(int _label) {
            children = new HashMap<Integer, UnionFindNode>();
            parent = this;
            label = _label;
        }
        
        public boolean union(UnionFindNode p) {
            UnionFindNode pParent = p.parent;
            UnionFindNode thisParent = this.parent;
            if (pParent==thisParent) {
                return false;
            }
            thisParent.children.putAll(pParent.children);
            for (UnionFindNode n: pParent.children.values()) {
                n.parent=thisParent;
            }
            thisParent.children.put(pParent.label, pParent);
            pParent.parent = thisParent;
            pParent.children.clear();
            return true;
        }
    }
}
