package lzhou.programmingtest.leetcode.teet436;

import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        Pair[] startAndIndex = new Pair[intervals.length];
        for (int i=0; i<intervals.length; ++i) {
            startAndIndex[i] = new Pair(intervals[i].start, i);
        }
        
        Arrays.sort(startAndIndex, new PairComparatorByV1());
        
        int[] ret = new int[intervals.length];
        
        for (int i=0; i<intervals.length; ++i) {
            int found = Arrays.binarySearch(startAndIndex, new Pair( intervals[i].end, 0), new PairComparatorByV1());
            if (found>=0) {
                ret[i]=startAndIndex[found].v2;
            } else {
                found = -found-1;
                if (found==startAndIndex.length) {
                    ret[i] = -1;
                } else {
                    ret[i] = startAndIndex[found].v2;
                }
            }
        }
        return ret;
    } 
}

class Pair {
    int v1;
    int v2;
    Pair(int _v1, int _v2) {
        v1=_v1;
        v2=_v2;
    }
}

class PairComparatorByV1 implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        int ret = Integer.compare(p1.v1, p2.v1);
        if (ret==0) {
            ret = Integer.compare(p1.v2, p2.v2);
        }
        return ret;
    }
}
