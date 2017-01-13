package lzhou.programmingtest.leetcode.test403;

import java.util.*;

public class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        
        for (int s : stones) {
            map.put(Integer.valueOf(s), new HashSet<Integer>());
        }
        map.get(Integer.valueOf(0)).add(Integer.valueOf(0));
        
        for (int s: stones) {
            for (Integer boxedLastJump: map.get(Integer.valueOf(s))) {
                int lastJump = boxedLastJump.intValue();
                if (lastJump-1>0) {
                    addJump(map, s, lastJump-1);
                }
                if (lastJump>0) {
                    addJump(map, s, lastJump);
                }
                if (lastJump+1>0) {
                    addJump(map, s, lastJump+1);
                }
            }
            if (map.get(stones[stones.length-1]).size()>0) {
                return true;
            }
        }
        return false;
    }
    
    private void addJump(HashMap<Integer, HashSet<Integer>> map, int stone, int jump) {
        if (jump<=0) {
            return;
        }
        Integer key = Integer.valueOf(stone+jump);
        if (map.containsKey(key)) {
            map.get(key).add(Integer.valueOf(jump));   
        }
    }
}
