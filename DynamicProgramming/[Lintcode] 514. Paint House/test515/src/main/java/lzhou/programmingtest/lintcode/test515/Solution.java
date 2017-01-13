package lzhou.programmingtest.lintcode.test515;

public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        if (costs.length==0) {
            return 0;
        } 
        int[] prev = new int[3];
        int[] cur = new int[3];
        int[] leftMin = new int[3];
        int[] rightMin = new int[3];
        for (int[] cost: costs) {
            for (int i=0; i<3; ++i) {
                if (i==0) {
                    leftMin[i]=Integer.MAX_VALUE;
                } else {
                    leftMin[i]=Math.min(leftMin[i-1], prev[i-1]);
                }
            }
            for (int i=3-1; i>=0; --i) {
                if (i==3-1) {
                    rightMin[i]=Integer.MAX_VALUE;
                } else {
                    rightMin[i]=Math.min(rightMin[i+1], prev[i+1]);
                }
            }
            
            for (int i=0; i<3; ++i) {
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
