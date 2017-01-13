package lzhou.programmingtest.leetcode.test56;
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
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals.size()==0) {
            return intervals;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                int ret = Integer.compare(o1.start, o2.start);
                if (ret==0) {
                    ret = -Integer.compare(o1.end, o2.end);
                }
                return ret;
            }
        });
        
        Interval cur = intervals.get(0);
        
        for (int i=1; i<intervals.size();) {
            Interval tmp = intervals.get(i);
            if (cur.end>=tmp.start) {
                cur.end=Math.max(cur.end, tmp.end);
                intervals.remove(i);
            } else {
                cur = tmp;
                i+=1;
            }
        }
        
        return intervals;
    }
}
