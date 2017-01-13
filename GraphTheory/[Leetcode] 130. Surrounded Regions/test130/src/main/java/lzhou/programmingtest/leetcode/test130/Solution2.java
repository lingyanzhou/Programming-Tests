package lzhou.programmingtest.leetcode.test130;

import java.util.*;

/* UnionFind solution.
 * Keep a union set called boundary.
 * After merging all connected 'O', test whether a set is in the boundary set or not.
 */

public class Solution2 {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        int n = board.length;
        if (n==0) {
            return;
        }
        int m = board[0].length;
        if (m==0) {
            return;
        }
        
        UnionFindNode boundary  = new UnionFindNode(-1, -1);
        UnionFindNode[][] nodes = new UnionFindNode[n][m];
        
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (board[i][j]=='O') {
                    nodes[i][j] = new UnionFindNode(i, j);
                }
            }
        }
        
        for (int i=0; i<n; ++i) {
            if (board[i][0]=='O') {
                boundary.union(nodes[i][0]);
            }
        }
        for (int i=0; i<n; ++i) {
            if (board[i][m-1]=='O') {
                boundary.union(nodes[i][m-1]);
            }
        }
        for (int i=0; i<m; ++i) {
            if (board[0][i]=='O') {
                boundary.union(nodes[0][i]);
            }
        }
        for (int i=0; i<m; ++i) {
            if (board[n-1][i]=='O') {
                boundary.union(nodes[n-1][i]);
            }
        }
        
        for (int i=1; i<n; ++i) {
            for (int j=1; j<m; ++j) {
                if (board[i][j]=='O') {
                    if (board[i-1][j]=='O') {
                        nodes[i][j].union(nodes[i-1][j]);
                    }
                    if (board[i][j-1]=='O') {
                        nodes[i][j].union(nodes[i][j-1]);
                    }
                }
            }
        }
        for (int i=1; i<n-1; ++i) {
            for (int j=1; j<m-1; ++j) {
                if (board[i][j]=='O') {
                    if (!boundary.inSameSet(nodes[i][j])) {
                        board[i][j]='X';
                    }
                }
            }
        }
    }
    
}

class UnionFindNode {
    public int i;
    public int j;
    public UnionFindNode parent;
    public UnionFindNode(int _i, int _j) {
        i=_i;
        j=_j;
        parent=this;
    }
    
    public UnionFindNode getRoot() {
        UnionFindNode root = this;
        Stack<UnionFindNode> stack = new Stack<UnionFindNode>();
        while (root.parent!=root) {
            stack.push(root);
            root = root.parent;
        }
        while (stack.size()>0) {
            stack.pop().parent=root;
        }
        return root;
    }
    
    public void union(UnionFindNode n) {
        n.getRoot().parent = getRoot();
        n.parent = getRoot();
    }
    
    public boolean inSameSet(UnionFindNode n) {
        return getRoot()==n.getRoot();
    }
}
