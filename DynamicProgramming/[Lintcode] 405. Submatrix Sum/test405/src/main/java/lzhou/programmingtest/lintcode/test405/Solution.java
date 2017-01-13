package lzhou.programmingtest.lintcode.test405;

import java.util.*;

/*
 * Ref: Kadane's algorithm.
        http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
 */
public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        if (matrix.length==0 || matrix[0].length==0) {
            return null;
        }
        long[][] sum = new long[matrix.length+1][matrix[0].length+1];
        for (int i=0; i<matrix.length; ++i) {
            for (int j=0; j<matrix[0].length; ++j) {
                sum[i+1][j+1] = sum[i+1][j]+sum[i][j+1]-sum[i][j]+matrix[i][j];
            }
        }
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        //Fix the lower row
        for (int l=0; l<matrix.length; ++l) {
            //Fix the upper row
            for (int u=l+1; u<=matrix.length; ++u) {
                map.clear();
                for (int c=0; c<=matrix[0].length; ++c) {
                    long sumToC = sum[l][c]-sum[u][c];
                    if (map.containsKey(sumToC)) {
                        int[][] ret = new int[2][2];
                        ret[0][0] = l;
                        ret[0][1] = map.get(sumToC);
                        ret[1][0] = u-1;
                        ret[1][1] = c-1;
                        return ret;
                    } else {
                        map.put(sumToC, c);
                    }
                    
                }  
            }
        }
        return null;
    }
}
