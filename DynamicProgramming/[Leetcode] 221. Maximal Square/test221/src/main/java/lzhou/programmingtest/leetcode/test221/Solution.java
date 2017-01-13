package lzhou.programmingtest.leetcode.test221;

import java.util.*;

/*
 * A nxn square ending at (i,j) is 
 *   1) a 1 at (i, j) 
 *   2) (n-1)x(n-1) squares ending at (i-1, j), (i, j-1), (i-1, j-1)
 */
public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maximalSquare(char[][] matrix) {
        // write your code here
        int n=matrix.length;
        if (n==0) {
            return 0;
        }
        int m=matrix[0].length;
        if (m==0) {
            return 0;
        }
        int[][] matrixDp = new int[n][m];
        int ret = 0;
        for (int i=0; i<n; ++i) {
            if (matrix[i][0]=='1') {
                matrixDp[i][0]=1;
                ret=1;
            }
        }
        for (int j=0; j<m; ++j) {
            if (matrix[0][j]=='1') {
                matrixDp[0][j]=1;
                ret=1;
            }
        }
        for (int i=1; i<n; ++i) {
            for (int j=1; j<m; ++j) {
                if (matrix[i][j]=='1') {
                    matrixDp[i][j] = 1+Math.min(matrixDp[i-1][j-1], Math.min(matrixDp[i][j-1], matrixDp[i-1][j]));
                    ret = Math.max(ret, matrixDp[i][j]);
                    //System.out.println(ret);
                }
            }
        }
        return ret*ret;
    }
}
