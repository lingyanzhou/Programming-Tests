package lzhou.programmingtest.leetcode.test123;

import java.util.*;

/*
 * DP:
 * buy[i]: the max profit we get when we buy the stock at or before i (or min money we owe)
 * sell[i]: the max profit we get when we sell the stock at or before i
 *
 * Transition:
 * buy[i] = max(buy[i-1], -price[i]);
 * sell[i] = max(sell[i-1], price[i]+buy[i]);
 * ...
 */
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int p: prices) {
            buy1 = Math.max(buy1, -p);
            sell1 = Math.max(sell1, p+buy1);
            buy2 = Math.max(buy2, sell1-p);
            sell2 = Math.max(sell2, p+buy2);
        }

        return sell2;
    }
}
