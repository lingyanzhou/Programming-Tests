package lzhou.programmingtest.leetcode.test542;

import java.util.*;

public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int n=matrix.size();
        if (n==0) {
            return null;
        }
        int m=matrix.get(0).size();
        if (m==0) {
            return null;
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<int[]> interestingPoints = new LinkedList<int[]>();
        for (int i=0; i<n; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j=0; j<m; ++j) {
                int tmp = matrix.get(i).get(j);
                if (tmp==0) {
                    row.add(tmp);
                    interestingPoints.offer(new int[]{i, j});
                } else {
                    row.add(Integer.MAX_VALUE);
                }
                
            }
            result.add(row);
        }
        
        while(interestingPoints.size()>0) {
            int[] coord = interestingPoints.poll();
            int x = coord[0];
            int y = coord[1];
            long dist = result.get(x).get(y);
            if (x-1>=0) {
                if (updateDistance(result, x-1, y, dist+1)) {
                    interestingPoints.offer(new int[]{x-1, y});
                }
            }
            if (x+1<n) {
                if (updateDistance(result, x+1, y, dist+1)) {
                    interestingPoints.offer(new int[]{x+1, y});
                }
            }
            if (y-1>=0) {
                if (updateDistance(result, x, y-1, dist+1)) {
                    interestingPoints.offer(new int[]{x, y-1});
                }
            }
            if (y+1<m) {
                if (updateDistance(result, x, y+1, dist+1)) {
                    interestingPoints.offer(new int[]{x, y+1});
                }
            }
        }
        
        return result;
    }
    
    private boolean updateDistance(List<List<Integer>> distances, int x, int y, long dist) {
        if (x>=0 && x<distances.size() && y>=0 && y<distances.get(x).size()) {
            if (distances.get(x).get(y)>dist) {
                distances.get(x).set(y, (int)dist);
                return true;
            }
        }
        return false;
    }
}
