package lzhou.programmingtest.leetcode.test391;

import java.util.*;

/**
 * Ref: http://www.cnblogs.com/grandyang/p/5825619.html

Idea:
    * There are three kind of corners, T, L and +
    * If no corner is overlaping each other, T corner is formed by two rectangles, + by 4, L by one. 
    * Our target is to find exactly 4 L corners, and that the area of the rectangle formed by the 4L corners equals the total area of the smaller rectangles.
    * Use a hashset to keep track of all corners. If they appear twice, reset their appearance to 0. In the end, we have all corners that appeared once, or odd number of times.
 */
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<Point> cornerPoints = new HashSet<Point>();
        long areaSum = 0;
        for (int[] rect: rectangles) {
            
            areaSum += ((long)rect[2]-rect[0])*((long)rect[3]-rect[1]);
            
            Point[] p = new Point[]{new Point(rect[0], rect[1]),new Point(rect[2], rect[3]),new Point(rect[0], rect[3]),new Point(rect[2], rect[1])};
            for (int i=0; i<4; ++i) {
                if (cornerPoints.contains(p[i])) {
                    cornerPoints.remove(p[i]);
                } else {
                    cornerPoints.add(p[i]);
                }
            }
        }
        
        if (cornerPoints.size()==4) {
            int h=0;
            int w=0;
            Point ref = null;
            for (Point p:cornerPoints) {
                if (ref==null) {
                    ref=p;
                } else {
                    h=Math.max(h, Math.abs(p.y-ref.y));
                    w=Math.max(w, Math.abs(p.x-ref.x));
                }
            }
            long boundingRectArea = (long)h*w;
            return boundingRectArea==areaSum;
        } else {
            return false;
        }
    }
}

class Point {
    int x,y;
    Point(int _x, int _y) {
        x=_x;
        y=_y;
    }
    public String toString() {
        return "x="+x+", y="+y;
    }
    public int hashCode() {
        return x*131071+y;
    }
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point oo = (Point)o;
            return x==oo.x && y==oo.y;
        }
        return false;
    }
}
