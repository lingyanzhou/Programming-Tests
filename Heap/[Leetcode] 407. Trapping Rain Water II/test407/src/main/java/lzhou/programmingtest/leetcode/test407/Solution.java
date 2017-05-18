package lzhou.programmingtest.leetcode.test407;

import java.util.*;

import java.util.stream.*;

public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        int n = heights.length;
        if (n<=2) {
            return 0;
        }
        int m = heights[0].length;
        if (m<=2) {
            return 0;
        }
        PriorityQueue<HeightLoc> queue = new PriorityQueue<HeightLoc>();
        boolean[][] seen = new boolean[n][m];
        for (int i=0; i<m; ++i) {
            queue.offer(new HeightLoc(heights[0][i], 0, i));
            seen[0][i]=true;
            queue.offer(new HeightLoc(heights[n-1][i], n-1, i));
            seen[n-1][i]=true;
        }
        for (int i=1; i<n-1; ++i) {
            queue.offer(new HeightLoc(heights[i][0], i, 0));
            seen[i][0]=true;
            queue.offer(new HeightLoc(heights[i][m-1], i, m-1));
            seen[i][m-1]=true;
        }
        int waterVolume = 0;
        int wallHeight = 0;
        while (queue.size()>0) {
            HeightLoc cur = queue.poll();
            if (cur.height>wallHeight) {
                wallHeight = cur.height;
            }
            waterVolume += wallHeight - cur.height;
            
            for (int[] d: directions) {
                int newRow = cur.row + d[0];
                int newCol = cur.col + d[1];
                if (canChoose(n, m, newRow, newCol, seen)) {
                    seen[newRow][newCol] = true;
                    queue.offer(new HeightLoc(heights[newRow][newCol], newRow, newCol));
                }
            }
        }
        return waterVolume;
    }
    
    private static int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    private static boolean canChoose(int n, int m, int i, int j, boolean[][] seen) {
        if (i<0 || j<0 || i>=n || j>=m || seen[i][j]) {
            return false;
        }
        return true;
    }
};

class HeightLoc implements Comparable<HeightLoc> {
    int height;
    int row;
    int col;
    HeightLoc(int h, int r, int c) {
        height = h;
        row = r;
        col = c;
    }
    
    public int compareTo(HeightLoc o2) {
        return Integer.compare(height, o2.height);
    }
}
