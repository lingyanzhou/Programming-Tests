package lzhou.programmingtest.leetcode.test51;

import java.util.*;

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> result = new ArrayList<List<String>>();
        int[] position = new int[n];
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];
        
        solveNQueensHelper(position, 0, col, diag, rdiag, result);
        
        return result;
    }
    
    private void solveNQueensHelper(int[] position, int start, boolean[] col, boolean[] diag, boolean[] rdiag, List<List<String>> results) {
        int n=position.length;
        if (n==start) {
            results.add(toListOfString(position));
            return;
        }
        for (int i=0; i<n; ++i) {
            if (col[i] || diag[calcDiagIndex(n, start, i)] || rdiag[calcReverseDiagIndex(start, i)]) {
                continue;
            } else {
                col[i] =true;
                diag[calcDiagIndex(n, start, i)]=true;
                rdiag[calcReverseDiagIndex(start, i)]=true;
                position[start]=i;
                solveNQueensHelper(position, start+1, col, diag, rdiag, results);
                col[i] =false;
                diag[calcDiagIndex(n, start, i)]=false;
                rdiag[calcReverseDiagIndex(start, i)]=false;
            }
        }
    }
    
    private static List<String> toListOfString(int[] position) {
        int n=position.length;
        List<String> ret = new ArrayList<String>(n);
        for (int i=0; i<n; ++i) {
            char[] buff= new char[n];
            Arrays.fill(buff, '.');
            buff[position[i]]='Q';
            ret.add(new String(buff));
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
