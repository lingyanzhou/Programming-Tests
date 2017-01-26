package question309

import (
    "math"
)

/**
DP solution:
  * buy[i] means the max profit at step i if the last operation is "buy".
    sell[i] means the max profit at step i if the last operation is "sell".
    cooldown[i] means the max profit at step i if the last operation is "cooldown".
  * Transfer function:
     * buy[i] = max(buy[i-1], cooldown[i-1]-price[i])
     * sell[i] = max(sell[i-1], price[i]+buy[i-1])
     * cooldown[i] = max(cooldown[i-1], sell[i-11])
 */
func maxProfit(prices []int) int {
    buy := math.MinInt32
    sell := 0
    cooldown:=0
    for _, p:= range prices {
        buyOld := buy
        sellOld := sell
        cooldownOld := cooldown
        buy = int(math.Max(float64(buyOld), float64(cooldownOld-p))) //
        sell = int(math.Max(float64(sellOld), float64(p+buyOld)))
        cooldown = int(math.Max(float64(cooldownOld), float64(sellOld)))
    }
    
    return int(math.Max(float64(sell), float64(cooldown)))
}
