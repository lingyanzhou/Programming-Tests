package lzhou.programmingtest.leetcode.test85;

import java.util.*;

/**
 * Idea:
 *   1. For each row, view all the rows above as a histogram.
 *   2. Use the solution in Largest Rectangle in Histogram.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        if (n==0) {
            return 0;
        }
        int m=matrix[0].length;
        if (m==0) {
            return 0;
        }
        int ret = 0;
        int[] verticallyCompressed = new int[m+2];
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                verticallyCompressed[j+1] += matrix[i][j]-'0';
            }
            ret = Math.max(ret, maxRectangleInHistogram(verticallyCompressed));
        }
        return ret;
    }
    
    private int maxRectangleInHistogram(int[] nums) {
        int[] stack = new int[nums.length];
        int len = 1;
        
        int ret = 0;
        for (int i=0; i<nums.length; ++i) {
            int n= nums[i];

            if (len==0 || nums[stack[len-1]]<=n) {
                stack[len]=i;
                len+=1;
            } else {
                while (len>1 && nums[stack[len-1]]>n) {
                    ret = Math.max(ret, (i-stack[len-2]-1)*nums[stack[len-1]]);
                    len-=1;
                }
                stack[len]=i;
                len+=1;
            }
        }
        
        return ret;
    }
}
