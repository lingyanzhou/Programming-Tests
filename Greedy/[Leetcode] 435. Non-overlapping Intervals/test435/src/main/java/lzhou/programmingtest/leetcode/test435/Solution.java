package lzhou.programmingtest.leetcode.test435;

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
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new IntervalComparator());
        Interval last = null;
        int ret = 0;
        for (Interval i: intervals) {
            if (last==null) {
                last = i;
            } else {
                if (last.end>i.start) {
                    ret+=1;
                } else {
                    last = i;
                }
            }
        }
        
        return ret;
    }
    
    static class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            int ret = Integer.compare(i1.end, i2.end);
            return ret;
        }
    }
}
