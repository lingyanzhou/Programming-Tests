package lzhou.programmingtest.leetcode.test304;

import java.util.*;

public class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        dp=null;
        if (matrix.length>0 && matrix[0].length>0) {
            dp = new int[matrix.length+1][matrix[0].length+1];
            for (int i=0; i<matrix.length; ++i) {
                for (int j=0; j<matrix[0].length; ++j) {
                    dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1]-dp[i][j]+matrix[i][j];   
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp==null) {
            return 0;
        }
        row1=Math.max(0, Math.min(dp.length-1, row1));
        col1=Math.max(0, Math.min(dp[0].length-1, col1));
        row2=Math.max(0, Math.min(dp.length-1, row2+1));
        col2=Math.max(0, Math.min(dp[0].length-1, col2+1));
        
        return dp[row2][col2]+dp[row1][col1]-dp[row1][col2]-dp[row2][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
