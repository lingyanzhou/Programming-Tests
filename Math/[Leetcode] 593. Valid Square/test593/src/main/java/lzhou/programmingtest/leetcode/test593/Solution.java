package lzhou.programmingtest.leetcode.test593;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] array = new int[][]{p1, p2, p3, p4};
        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                int ret = Integer.compare(o1[0], o2[0]);   
                if (ret==0) {
                    ret = Integer.compare(o1[1], o2[1]); 
                }
                return ret;
            }
        });
        
        return array[1][1]-array[0][1]!=0 && perpendicular(array[0], array[1], array[3]) && 
        perpendicular(array[1], array[3], array[2]) && 
        perpendicular(array[3], array[2], array[0]) && 
        perpendicular(array[2], array[0], array[1]) &&
        lengthSqr(array[0], array[1])==lengthSqr(array[1], array[3])
        ;
    }
    
    private boolean perpendicular(int[] p1, int[] p2, int[] p3) {
        return (p2[0]-p1[0])*(p3[0]-p2[0])+(p2[1]-p1[1])*(p3[1]-p2[1])==0;
    }
    
    private long lengthSqr(int[] p1, int[] p2) {
        return ((long)p2[0]-p1[0])*((long)p2[0]-p1[0])+((long)p2[1]-p1[1])*((long)p2[1]-p1[1]);
    }
}
