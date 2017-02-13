package lzhou.programmingtest.lintcode.test185;

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        if (matrix.length==0 || matrix[0].length==0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ret = new int[matrix.length*matrix[0].length];
        int retI = 0;
        int dir = -1;
        for (int i=0; i<m+n-1; ++i) {
            int k=Math.min(n-1, i);
            int j=i-k;
            if (dir==-1) {
                j=Math.min(m-1, i);
                k=i-j;
            }
            while (j<m && k<n && k>=0 && j>=0) {
                ret[retI] = matrix[j][k];
                retI+=1;
                j+=dir;
                k-=dir;
            }
            
            dir =-dir;
        }
        return ret;
    }
}
