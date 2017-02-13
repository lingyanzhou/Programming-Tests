# 188. Best Time to Buy and Sell Stock IV

##DP Solution

* States:
    *  `buy[j][i]` means the max profit we can get if we buy at day `i`, and previously we already had j-1 transactions.
    * `sell[j][i]` means the max profit we can get if we sell at day `i`, and previously we already had j-1 transactions (not including this transaction).

* Transfer function:
    *    `buy[j][i] = max(buy[j][i], sell[j-1][i]-prices[i])`
    *    `sell[j][i] = max(sell[j][i], buy[j][i]+prices[i])`
 
 * Optimization
	 * The max allowed transaction number `k` is larger than the number of days. The problem is reduced to k=inf.
	 * To speed up, we calculate `buy`arrays at valleys, and `sell` at peaks.
