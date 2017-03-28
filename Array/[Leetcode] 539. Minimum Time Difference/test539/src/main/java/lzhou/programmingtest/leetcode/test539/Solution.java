package lzhou.programmingtest.leetcode.test539;

import java.util.*;

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size()==0) {
            return 0;
        }
        List<Integer> timePointsInts = new ArrayList<Integer>();
        for (String t:timePoints) {
            timePointsInts.add(parseTime(t));
        }
        
        Collections.sort(timePointsInts);
        
        int min = -timePointsInts.get(0)+timePointsInts.get(timePointsInts.size()-1);
        min = Math.min(min, 60*24-min);
        
        for (int i=0; i<timePointsInts.size()-1; i++) {
            min = Math.min(min, timePointsInts.get(i+1)-timePointsInts.get(i));
        }
        
        return min;
    }
    
    private int parseTime(String t) {
        int h = Character.digit(t.charAt(0),10)*10+Character.digit(t.charAt(1),10);
        int m = Character.digit(t.charAt(3),10)*10+Character.digit(t.charAt(4),10);
        return h*60+m;
    }
    
}
