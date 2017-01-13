package lzhou.programmingtest.lintcode.test366;

import java.util.*;

/* Devide and conquer
 * O(logn)
 * [Fn+1 Fn  ] =[1 1]^n
   [Fn   Fn-1]  [1 0]
 */
class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        if (n<=1) {
            return 0;
        }
        int[][] matrix = matrix2x2Pow(new int[][]{{1,1},{1,0}}, n-1);
        return matrix[0][1];
    }
    
    public int[][] matrix2x2Pow(int[][] matrix, int n) {
        if (n<=0) {
            return new int[][]{{1,1},{1,1}};
        }
        if (n==1) {
            return new int[][]{{matrix[0][0], matrix[0][1]},{matrix[1][0], matrix[1][1]}};
        }
        if (n%2==0) {
            int[][] m = matrix2x2Pow(matrix, n/2);
            return matrix2x2Mul(m, m);
        } else {
            int[][] m = matrix2x2Pow(matrix, n/2);
            m = matrix2x2Mul(m, m);
            return matrix2x2Mul(m, matrix);
        }
    }
    
    private int[][] matrix2x2Mul(int[][] m1, int[][] m2) {
        return new int[][]{{m1[0][0]*m2[0][0]+m1[0][1]*m2[1][0], m1[0][0]*m2[0][1]+m1[0][1]*m2[1][1]},
                           {m1[1][0]*m2[0][0]+m1[1][1]*m2[1][0], m1[1][0]*m2[0][1]+m1[1][1]*m2[1][1]}};
    }
}
