package lzhou.programmingtest.leetcode.test200;

import java.util.*;

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(char[][] grid) {
        // Write your code here
        int n=grid.length;
        if (n==0) {
            return 0;
        }
        int m=grid[0].length;
        if (m==0) {
            return 0;
        }
        
        UnionFindNode[][] gridNodes= new UnionFindNode[n][m];
        
        for (int i=0, id=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (grid[i][j]=='1') {
                    gridNodes[i][j] = new UnionFindNode(id);
                }
                id+=1;
            }
        }
        
        
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (gridNodes[i][j]!=null) {
                    if (i>0 && gridNodes[i-1][j]!=null) {
                        gridNodes[i][j].merge(gridNodes[i-1][j]);
                    }
                    
                    if (j>0 && gridNodes[i][j-1]!=null) {
                        gridNodes[i][j].merge(gridNodes[i][j-1]);
                    }
                }
            }
        }
        
        int ret = 0;
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (gridNodes[i][j]!=null) {
                    if (gridNodes[i][j].isRoot()) {
                        ret+=1;
                    }
                }
            }
        }
        return ret;
    }
    
    static class UnionFindNode {
        public UnionFindNode parent;
        public int value;
        public UnionFindNode(int val) {
            parent = this;
            value = val;
        }
        
        public void merge(UnionFindNode n) {
            n.getRoot().parent=getRoot();
            n.flatten();
            flatten();
        }
        
        public boolean isRoot() {
            return parent==this;
        }
        
        public UnionFindNode getRoot() {
            UnionFindNode root = this;
            while (root.parent!=root) {
                root= root.parent;
            }
            return root;
        }
        
        public void flatten() {
            parent = getRoot();
        }
    }
}
