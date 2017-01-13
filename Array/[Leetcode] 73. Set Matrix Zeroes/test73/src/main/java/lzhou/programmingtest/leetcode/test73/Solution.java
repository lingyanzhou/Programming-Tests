package lzhou.programmingtest.leetcode.test73;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        if (matrix.length==0 || matrix[0].length==0) {
            return;
        }
        boolean firstRow0 = false;
        int[] firstRow = matrix[0];
        for (int i=0; i<m; ++i) {
            if (firstRow[i]==0) {
                firstRow0 = true;
                break;
            }
        }

        for (int i=1; i<n; ++i) {
            boolean curRowZero = false;
            for (int j=0; j<m; ++j) {
                if (matrix[i][j]==0) {
                    curRowZero = true;
                    firstRow[j]=0;
                }
            }
            if (curRowZero) {
                for (int j=0; j<m; ++j) {
                    matrix[i][j]=0;
                }
            }
        }

        for (int j=0; j<m; ++j) {
            if (firstRow[j]==0) {
                for (int i=1; i<n; ++i) {
                    matrix[i][j]=0;
                }
            }
        }
        if (firstRow0) {
            for (int j=0; j<m; ++j) {
                matrix[0][j]=0;
            }
        }
    }
}
