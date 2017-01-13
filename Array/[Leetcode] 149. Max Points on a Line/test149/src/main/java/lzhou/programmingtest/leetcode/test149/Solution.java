package lzhou.programmingtest.leetcode.test149;

import java.util.*;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
        if (points==null) {
            return 0;
        }
        if (points.length<=1) {
            return points.length;
        }
        HashMap<Double, Integer> counts = new HashMap<Double, Integer>();
        int max = 2;
        for (int i=0; i<points.length; ++i) {
            counts.clear();
            Point cur = points[i];
            int dup = 0;
            for (int j=0; j<points.length; ++j) {
                if (i==j) {
                    continue;
                }
                Point p = points[j];
                double k = 0;
                if (p.x==cur.x && p.y==cur.y) {
                    dup+=1;
                    continue;
                } else if (p.x==cur.x) {
                    k=Double.POSITIVE_INFINITY;
                } else if (p.y==cur.y) {
                    k=0;
                } else {
                    k=((double)p.y-cur.y)/((double)p.x-cur.x);
                }
                int count = 2;
                if (counts.containsKey(k)) {
                    count = 1+counts.get(k);
                }
                counts.put(k, count);
            }
            max = Math.max(1+dup, max);
            for (int c: counts.values()) {
                max = Math.max(c+dup, max);
            }
        }
        return max;
    }
}
