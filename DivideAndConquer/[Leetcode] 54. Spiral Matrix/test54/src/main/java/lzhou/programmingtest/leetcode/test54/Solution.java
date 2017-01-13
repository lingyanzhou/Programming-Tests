package lzhou.programmingtest.leetcode.test54;

import java.util.*;

/*
 * Remove the row/column after we traverse it
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        int n=matrix.length;
        if (n<=0) {
            return ret;
        }
        int m= matrix[0].length;
        if (m<=0) {
            return ret;
        }
        int colStart = 0;
        int rowStart = 0;
        int colEnd = m-1;
        int rowEnd = n-1;
        int direction = 0;
        
        while (colStart<=colEnd && rowStart<=rowEnd) {
            switch(direction) {
                case 0:
                    for (int i=colStart; i<=colEnd; ++i) {
                        ret.add(Integer.valueOf(matrix[rowStart][i]));
                    }
                    rowStart +=1;
                    direction = 1;
                    break;
                case 1:
                    for (int i=rowStart; i<=rowEnd; ++i) {
                        ret.add(Integer.valueOf(matrix[i][colEnd]));
                    }
                    colEnd -=1;
                    direction = 2;
                    break;
                case 2:
                    for (int i=colEnd; i>=colStart; --i) {
                        ret.add(Integer.valueOf(matrix[rowEnd][i]));
                    }
                    rowEnd -=1;
                    direction = 3;
                    break;
                case 3:
                    for (int i=rowEnd; i>=rowStart; --i) {
                        ret.add(Integer.valueOf(matrix[i][colStart]));
                    }
                    colStart +=1;
                    direction = 0;
                    break;
            }
        }
        
        return ret;
    }
}
