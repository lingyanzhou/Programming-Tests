package lzhou.programmingtest.leetcode.test188;

import java.util.*;

class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        prices= compress(prices);

        if (k>=prices.length/2) {
            return maxProfitIfNoKLimit(prices);
        }
        
        int[] buy = new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k+1];
        
        int bi = 0;
        int si = 0;
        
        int prev = Integer.MAX_VALUE;
        for (int p:prices) {
            if (prev>p) {
                bi=Math.min(bi+1, k);
                
                for (int i=1; i<=bi; ++i) {
                    buy[i] = Math.max(buy[i],sell[i-1]-p);
                }
            } else if (prev<p) {
                si=Math.min(si+1, k);
                for (int i=1; i<=si; ++i) {
                    sell[i] = Math.max(sell[i], buy[i]+p);
                }
            }
            prev=p;
        }
        
        return sell[si];
    }
    
    private int[] compress(int[] prices) {
        boolean negSlope = true;
        int prev = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        for (int i: prices) {
            if (i>prev) {
                if (negSlope) {
                    negSlope= false;
                    list.add(prev);
                }
            } else if (i<prev) {
                if (!negSlope) {
                    negSlope= true;
                    list.add(prev);
                }
            }
            prev = i;
        }
        
        if (!negSlope) {
            list.add(prices[prices.length-1]);
        }
        
        int[] ret = new int[list.size()];
        for (int i=0; i<ret.length; ++i) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    
    private int maxProfitIfNoKLimit(int[] prices) {
        int prev = Integer.MAX_VALUE;
        int ret = 0;
        for (int i: prices) {
            if (i>prev) {
                ret+= i-prev;
            }
            prev=i;
        }
        
        return ret;
    }
}
