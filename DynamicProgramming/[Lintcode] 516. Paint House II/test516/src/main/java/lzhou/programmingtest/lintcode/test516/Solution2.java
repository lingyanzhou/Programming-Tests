package lzhou.programmingtest.lintcode.test516;

import java.util.*;

/*
 * Observation: No matter how large k is,  we only need to keep track of previous min and second min values.
 * Suppose we paint i for current house. If previous min is not at i, we the cost is previous min + cost[i].
 *   If previous min is at i, then the cost is second min + cost[i].
 */
public class Solution2 {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // Write your code here
        int n = costs.length;
        if (costs.length==0) {
            return 0;
        } 
        int k = costs[0].length;
        int min1=0;
        int min2=0;
        int indexMin=-1;
        for (int[] cost: costs) {
            int curMin1 = Integer.MAX_VALUE;
            int curMin2 = Integer.MAX_VALUE;
            int curIndexMin = -1;
            for (int i=0; i<k; ++i) {
                int newCost = 0;
                if (i==indexMin) {
                    newCost = min2+cost[i];
                } else {
                    newCost = min1 +cost[i];
                }
                if (newCost<=curMin1) {
                    curIndexMin = i;
                    curMin2 = curMin1;
                    curMin1 = newCost;
                } else if (newCost<curMin2) {
                    curMin2 = newCost;
                }
                
            }

            min1 = curMin1;
            min2 = curMin2;
        }
    
        return min1;
    }
}
