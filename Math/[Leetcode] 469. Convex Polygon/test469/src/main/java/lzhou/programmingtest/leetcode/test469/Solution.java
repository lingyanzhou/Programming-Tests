package lzhou.programmingtest.leetcode.test469;

import java.util.*;

public class Solution 
{
	public boolean isConvex(int[][] points) {
		int n=points.length;
		assert n>=3;
		int[][] pointsNew = new int[n+2][];
		pointsNew[0] = points[n-2];
		pointsNew[1] = points[n-1];
		for (int i=0; i<n; ++i) {
			pointsNew[i+2] = points[i];
		}
		
		int direction = 0;
		for (int i=0; i<n; ++i) {
			int x1 = pointsNew[i+1][0]-pointsNew[i][0];
			int x2 = pointsNew[i+2][0]-pointsNew[i+1][0];
			int y1 = pointsNew[i+1][1]-pointsNew[i][1];
			int y2 = pointsNew[i+2][1]-pointsNew[i+1][1];
			int dir = x1*y2-x2*y1;
			if (dir==0) {
				throw new RuntimeException();
			}
			if (direction==0) {
				direction = dir;
			} else {
				if (direction*dir<0) {
					return false;
				}
			}
		}
		
		return true;
	}
}
