package lzhou.programmingtest.leetcode.test587;

import java.util.*;

import java.util.stream.*;

/**
 * QuickHull
 */
public class Solution {
    public List<Point> outerTrees(Point[] points) {
        if (points.length==0) {
            return new ArrayList<Point>();
        }
        if (points.length==1) {
            List<Point> border = new ArrayList<Point>();
            border.add(points[0]);
            return border;
        }
        List<Point> border = new ArrayList<Point>();
        Point minPoint = points[0];
        Point maxPoint = points[0];
        
        for (Point p:points) {
            if (p.x<minPoint.x || (p.x==minPoint.x && p.y>minPoint.y)) {
                minPoint = p;
            }
            if (p.x>maxPoint.x || (p.x==maxPoint.x && p.y<maxPoint.y)) {
                maxPoint = p;
            }
        }
        
        border.add(minPoint);
        border.add(maxPoint);
        
        List<Point> pointList = new ArrayList<Point>();
        for (Point p:points) {
            pointList.add(p);
        }
        
        Split spl = split(minPoint, maxPoint, pointList);
        
        findBoundary(minPoint, maxPoint, spl.pos, border);
        findBoundary(maxPoint, minPoint, spl.neg, border);
        
        return border;
    }
    
    private void findBoundary(Point l1, Point l2, List<Point> points, List<Point> border) {
        if (points.size()==0) {
            return;
        } else {
            Point l3 = getMaxDistancePoint(l1, l2, points);
            border.add(l3);
            Split spl = split(l1, l3, points);
            findBoundary(l1, l3, spl.pos, border);
            spl = split(l3, l2, spl.neg);
            findBoundary(l3, l2, spl.pos, border);
        }
    }
    
    private int area(Point l1, Point l2, Point p) {
        return (l2.x-l1.x)*p.y-(l2.y-l1.y)*p.x+l1.x*l2.y-l1.y*l2.x;
    }
    
    private Point getMaxDistancePoint(Point l1, Point l2, List<Point> points) {
        int maxDist = 0;
        Point result = null;
        
        for (Point p:points) {
            int tmp = area(l1, l2, p);
            if (maxDist<=tmp) {
                result = p;
                maxDist = tmp;
            }
        }
        
        return result;
    }
    
    private Split split(Point l1, Point l2, List<Point> points) {
        List<Point> pos = new ArrayList<Point>();
        List<Point> neg = new ArrayList<Point>();
        for (Point p: points) {
            if (p==l1 || p==l2) {
            } else if (area(l1,l2,p)>=0) {
                pos.add(p);
            } else {
                neg.add(p);
            }
        }
        
        return new Split(pos, neg);
    }
    
    static class Split {
        List<Point> pos;
        List<Point> neg;
        Split(List<Point> pos, List<Point> neg) {
            this.pos = pos;
            this.neg = neg;
        }
    }
}
