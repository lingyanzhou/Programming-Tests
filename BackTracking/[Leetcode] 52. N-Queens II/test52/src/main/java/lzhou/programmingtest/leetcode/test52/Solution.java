package lzhou.programmingtest.leetcode.test52;

import java.util.*;

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        //write your code here
        int[] position = new int[n];
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];
        
        return totalNQueensHelper(position, 0, col, diag, rdiag);
    }
    
    private int totalNQueensHelper(int[] position, int start, boolean[] col, boolean[] diag, boolean[] rdiag) {
        int n=position.length;
        if (n==start) {
            return 1;
        }
        int ret = 0;
        for (int i=0; i<n; ++i) {
            if (col[i] || diag[calcDiagIndex(n, start, i)] || rdiag[calcReverseDiagIndex(start, i)]) {
                continue;
            } else {
                col[i] =true;
                diag[calcDiagIndex(n, start, i)]=true;
                rdiag[calcReverseDiagIndex(start, i)]=true;
                position[start]=i;
                ret+=totalNQueensHelper(position, start+1, col, diag, rdiag);
                col[i] =false;
                diag[calcDiagIndex(n, start, i)]=false;
                rdiag[calcReverseDiagIndex(start, i)]=false;
            }
        }
        return ret;
    }
    
    private static int calcDiagIndex(int n, int r, int c) {
        return n-1-c+r;
    }
    
    private static int calcReverseDiagIndex(int r, int c) {
        return c+r;
    }
};

