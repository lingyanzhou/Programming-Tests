package lzhou.programmingtest.leetcode.test554;

import java.util.*;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int h = wall.size();
        int width = 0;
        for (List<Integer> line: wall) {
            int len = 0;
            for (Integer brick : line) {
                len+=brick;
                count.put(len, count.getOrDefault(len, h)-1);
            }
            width = len;
        }
        count.remove(width);
        
        int result = h;
        for (Integer i: count.values()) {
            result = Math.min(result, i);
        }
        
        return result;
    }
}
