package lzhou.programmingtest.leetcode.test74;

import java.util.*;

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int m=matrix.length;
        if (m==0) {
            return false;
        }
        int n=matrix[0].length;
        if (n==0) {
            return false;
        }
        
        int rs = 0;
        int re = m;
        while (rs<re) {
            int mid = (rs+re)/2;
            if (matrix[mid][0]>target) {
                re = mid;
            } else if (matrix[mid][n-1]<target) {
                rs = mid+1;
            } else { //matrix[mid][n-1]>=target && matrix[mid][0]<=target
                rs = mid;
                re=mid+1;
                break;
            }
        }
        
        if (rs==re) {
            return false;
        }
        
        int index = Arrays.binarySearch(matrix[rs], target);
        if (index<0) {
            return false;
        }
        return true;
    }
}
