package lzhou.programmingtest.leetcode.test296;

import java.util.*;

/**
 * Idea:
 *   * Best column/row to meet is the median of all their columns/rows.
 */
public class Solution 
{
    public int minTotalDistance(int[][] grid) {
        if (grid.length==0) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        int total = 0;
        for (int i=0; i<grid.length; ++i) {
            for (int j=0; j<grid[i].length; ++j) {
                if (grid[i][j]==1) {
                    list.add(i);
                }
            }
        }
        for (int i: list) {
            total+=Math.abs(i-list.get((list.size()-1)/2));
        }
        list.clear();
        for (int i=0; i<grid[0].length; ++i) {
            for (int j=0; j<grid.length; ++j) {
                if (grid[j][i]==1) {
                    list.add(i);
                }
            }
        }
        for (int i: list) {
            total+=Math.abs(i-list.get((list.size()-1)/2));
        }
        return total;
    }
}
