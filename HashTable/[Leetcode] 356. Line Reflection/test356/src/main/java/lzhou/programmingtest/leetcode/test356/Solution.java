package lzhou.programmingtest.leetcode.test356;

import java.util.*;

public class Solution 
{
    boolean isReflected(int[][] points) {
        Set<Pair> set = new HashSet<Pair>();
        int len = points.length;
        if (len%2!=0 || len==0) {
            return false;
        }
        double reflectionX = 0;
        for (int i=0; i<len; ++i) {
            reflectionX += points[i][0];
            set.add(new Pair(points[i][0], points[i][1]));
        }
        reflectionX /= len;

        for (int i=0; i<len; ++i) {
            if (!set.contains(new Pair((int)Math.round(2*reflectionX-points[i][0]), points[i][1]))) {
                return false;
            }
        }
        return true;
    }
}

class Pair {
    int x;
    int y;
    Pair(int _x, int _y) {
        x=_x;
        y=_y;
    }
    public int hashCode() {
        return x*1023+y;
    }
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair that = (Pair) o;
            return that.x==x && that.y==y;
        }
        return false;
    }
}
