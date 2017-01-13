package lzhou.programmingtest.leetcode.test121;

/*
 * DP:
 * buy[i]: the max profit we get when we buy the stock at or before i (or min money we owe)
 * sell[i]: the max profit we get when we sell the stock at or before i
 *
 * Transition:
 * buy[i] = max(buy[i-1], -price[i]);
 * sell[i] = max(sell[i-1], price[i]+buy[i]);
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        for (int i:prices) {
            buy = Math.max(buy, -i);
            sell = Math.max(sell, i+buy);
        }
        
        return sell;
    }
}
