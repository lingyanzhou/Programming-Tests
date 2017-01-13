package lzhou.programmingtest.leetcode.test57;
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<Interval>(intervals.size()+1);
        
        boolean notAdded = true;
        for (Interval intvl: intervals) {
            if (notAdded) {
                if (intvl.start<=newInterval.end && newInterval.start<=intvl.end) {
                    newInterval.end = Math.max(newInterval.end, intvl.end);
                    newInterval.start = Math.min(newInterval.start, intvl.start);
                } else if (intvl.start>newInterval.end) {
                    ret.add(newInterval);
                    ret.add(intvl);
                    notAdded=false;
                } else {
                    ret.add(intvl);
                }
            } else {
                ret.add(intvl);
            }
        }
        if (notAdded) {
            ret.add(newInterval);
        }
        
        return ret;
    }
}
