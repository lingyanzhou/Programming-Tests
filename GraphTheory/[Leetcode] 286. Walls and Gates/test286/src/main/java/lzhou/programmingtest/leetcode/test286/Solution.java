package lzhou.programmingtest.leetcode.test286;

import java.util.*;

/**
 * #BSF solution
 *
 * 1. Put all points with value 0s in a queue
 * 2. While the queue is not empty, pop its head, do the following:
 * 2.1. Find the adjacent empty rooms of the head that have not been assigned a value.
 * 2.2. Assign the distance. Push the rooms to the queue.
 * 
 */
public class Solution 
{
    final static int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        int n=rooms.length;
        if (n==0) {
            return;
        }
        int m=rooms[0].length;
        if (m==0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<int[]>();

        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (rooms[i][j]==0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (queue.size()>0) {
            int[] p = queue.poll();
            int v = rooms[p[0]][p[1]];
            if (p[0]+1<n && rooms[p[0]+1][p[1]]==INF) {
                rooms[p[0]+1][p[1]]=v+1;
                queue.offer(new int[]{p[0]+1, p[1]});
            }
            if (p[0]-1>=0 && rooms[p[0]-1][p[1]]==INF) {
                rooms[p[0]-1][p[1]]=v+1;
                queue.offer(new int[]{p[0]-1, p[1]});
            }
            if (p[1]+1<m && rooms[p[0]][p[1]+1]==INF) {
                rooms[p[0]][p[1]+1]=v+1;
                queue.offer(new int[]{p[0], p[1]+1});
            }
            if (p[1]-1>=0 && rooms[p[0]][p[1]-1]==INF) {
                rooms[p[0]][p[1]-1]=v+1;
                queue.offer(new int[]{p[0], p[1]-1});
            }
        }
    }
}
