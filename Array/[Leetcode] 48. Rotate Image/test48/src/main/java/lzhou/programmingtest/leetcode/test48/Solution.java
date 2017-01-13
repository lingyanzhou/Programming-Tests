package lzhou.programmingtest.leetcode.test48;

import java.util.*;

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        // write your code here
        int n=matrix.length;
        if (n==0) {
            return;
        }
        int mid = n/2;
        int mid2 = (n+1)/2;
        
        for (int i=0; i<mid2; ++i) {
            for (int j=0; j<mid; ++j) {
                int val = matrix[i][j];
                Point p = new Point(i, j);
                for (int k=0; k<4; ++k) {
                    rotate90cw(p, n);
                    int tmp =  matrix[p.x][p.y];
                    matrix[p.x][p.y] = val;
                    val = tmp;
                }
            }
        }
    }
    
    private Point rotate90cw(Point p, int n) {
        //System.out.println("p.x="+p.x+", p.y="+p.y);
        int x = p.x;
        p.x= p.y;
        p.y = n-1-x;
        return p;
    }
}
class Point {
    int x;
    int y;
    Point(int _x, int _y) {
        x=_x;
        y=_y;
    }
}
