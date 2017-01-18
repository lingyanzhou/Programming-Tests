package lzhou.programmingtest.leetcode.test135;

import java.util.*;

/**
 * Greedy:
 * 1. Find valleys (nums[i]>=nums[i+1]<=nums[i])
 * 2. Set valleys' candy to 1
 * 3. Go rightward, leftward from valleys, set their candies.
 */
public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // Write your code here
        int prev = -1;
        int lastPeak = -1;
        int peakCandy = 0;
        int prevCandy = 0;
        int totalCandy = 0;
        for (int i=0; i<=ratings.length; ++i) {
            int r = prev;
            if (i<ratings.length){
                r=ratings[i];
            }
            
            if (r>=prev) {
                if (lastPeak!=i-1) {
                    int lastPeakCandyBackward = i-lastPeak;
                    totalCandy += (i-lastPeak+1)*(i-lastPeak)/2;
                    if (peakCandy>lastPeakCandyBackward) {
                        totalCandy -= lastPeakCandyBackward;
                    } else {
                        totalCandy -= peakCandy;
                    }
                    prevCandy = 1;
                }
                if (i==ratings.length){
                    break;
                }
                lastPeak = i;
                if (r>prev) {
                    prevCandy += 1;
                } else {
                    prevCandy = 1;
                }
                peakCandy = prevCandy;
                totalCandy+=prevCandy;
            }
            prev =r;
        }
        return totalCandy;
    }
}
