package lzhou.programmingtest.leetcode.test309;

import java.util.*;

/**
 * DP solution:
 *
 *   * buy[i] means the max profit at step i if the last operation is "buy".
 *     sell[i] means the max profit at step i if the last operation is "sell".
 *     cooldown[i] means the max profit at step i if the last operation is "cooldown".
 *   * Transfer function:
 *     ** buy[i] = max(buy[i-1], cooldown[i-1]-price[i])
 *     ** sell[i] = max(sell[i-1], price[i]+buy[i-1])
 *     ** cooldown[i] = max(cooldown[i-1], sell[i-11])
 */ 
public class Solution 
{
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int cooldown=0;
        for (int p:prices) {
            int buyOld = buy;
            int sellOld = sell;
            int cooldownOld = cooldown;
            buy = Math.max(buyOld, cooldownOld-p); 
            sell = Math.max(sellOld, p+buyOld);
            cooldown = Math.max(cooldownOld, sellOld);
        }
        
        return Math.max(sell, cooldown);
    }
}
