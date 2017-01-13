package lzhou.programmingtest.lintcode.test391;

import java.util.*;

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if (airplanes.size()==0) {
            return 0;
        }
        PriorityQueue<StartEndPoint> queue = new PriorityQueue<StartEndPoint>();
        
        for (Interval ap: airplanes) {
            queue.offer(new StartEndPoint(ap.start, true));
            queue.offer(new StartEndPoint(ap.end, false));
        }
        
        int ret = 0;
        int cur = 0;
        
        while (queue.size()>0) {
            if (queue.poll().isStart) {
                cur+=1;
                ret = Math.max(ret, cur);
            } else {
                cur-=1;
            }
        }
        
        return ret;
    }
    
    static class StartEndPoint implements Comparable<StartEndPoint>{
        int val = 0;
        boolean isStart = false;
        public StartEndPoint(int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }
        
        public int compareTo(StartEndPoint p) {
            int ret = Integer.compare(val, p.val);
            if (ret==0) {
                if (isStart && !p.isStart) {
                    ret = 1;
                } else if (!isStart && p.isStart) {
                    ret = -1;
                }
            }
            return ret;
        }
    }
}
