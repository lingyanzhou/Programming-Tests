package lzhou.programmingtest.leetcode.test403;

import java.util.*;

public class Solution {
    /**
     * @param stones a list of stones' positions in sorted ascending order
     * @return true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        int n=stones.length;
        if (n==0) {
            return false;
        }
        if (n==1) {
            return true;
        }
        if (stones[0]!=0||stones[1]!=1) {
            return false;
        }
        
        Map<Integer, Set<Long>> dp = new HashMap<Integer, Set<Long>>();
        dp.put(0, new HashSet<Long>(Arrays.asList(0L)));
        dp.put(1, new HashSet<Long>(Arrays.asList(1L)));
        
        for (int i=2; i<n; ++i) {
            dp.put(stones[i], new HashSet<Long>());
        }
        
        for (int i=1; i<n; ++i) {
            int cur = stones[i];
            for (long step: dp.get(cur)) {
                if (step>1) {
                    long destination = cur+step-1;
                    if (destination<=Integer.MAX_VALUE && dp.containsKey((int)destination)) {
                        dp.get((int)destination).add(step-1);
                    }
                }
                long destination = cur+step;
                if (destination<=Integer.MAX_VALUE && dp.containsKey((int)destination)) {
                    dp.get((int)destination).add(step);
                }
                destination = cur+step+1;
                if (destination<=Integer.MAX_VALUE && dp.containsKey((int)destination)) {
                    dp.get((int)destination).add(step+1);
                }
            }
            if (dp.get(stones[n-1]).size()>0) {
                return true;
            }
        }
        return false;
    }
}
