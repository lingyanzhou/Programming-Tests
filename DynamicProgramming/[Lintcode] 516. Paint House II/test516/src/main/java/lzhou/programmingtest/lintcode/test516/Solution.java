package lzhou.programmingtest.lintcode.test516;

import java.util.*;

/*
 * Direct modification from Paint House problem.
 *  O(nk)
 */
public class Solution {
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
        int[] prev = new int[k];
        int[] cur = new int[k];
        int[] leftMin = new int[k];
        int[] rightMin = new int[k];
        for (int[] cost: costs) {
            
            for (int i=0; i<k; ++i) {
                if (i==0) {
                    leftMin[i]=Integer.MAX_VALUE;
                } else {
                    leftMin[i]=Math.min(leftMin[i-1], prev[i-1]);
                }
            }
            for (int i=k-1; i>=0; --i) {
                if (i==k-1) {
                    rightMin[i]=Integer.MAX_VALUE;
                } else {
                    rightMin[i]=Math.min(rightMin[i+1], prev[i+1]);
                }
            }
            
            for (int i=0; i<k; ++i) {
                cur[i] = Math.min(leftMin[i], rightMin[i]);
                cur[i] += cost[i];
            }
            int[] tmp = cur;
            cur = prev;
            prev = tmp;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i: prev) {
            min = Math.min(i, min);
        }
        return min;
    }
}
