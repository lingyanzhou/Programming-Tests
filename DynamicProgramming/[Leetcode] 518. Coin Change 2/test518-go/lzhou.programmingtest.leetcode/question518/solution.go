package question518

func change(amount int, coins []int) int {
    if amount==0 {
        return 1
    }
    if amount<0 || len(coins)==0 {
        return 0
    }
    dp := make([][]int, amount+1)
    for i,_ := range dp {
        dp[i] = make([]int, len(coins)+1)
    }
    for i,_ := range dp {
        for j,_ := range dp[i] {
            dp[i][j]=-1
        }
    }
    return changeHelper(amount, coins, dp)
}

func changeHelper(amount int, coins []int, dp [][]int) int {
    if amount==0 {
        return 1
    }
    if amount<0 || len(coins)==0 {
        return 0
    }
    if dp[amount][len(coins)]>=0 {
        return dp[amount][len(coins)]
    }
    dp[amount][len(coins)] = changeHelper(amount-coins[0], coins, dp)+ changeHelper(amount, coins[1:], dp)
    return dp[amount][len(coins)]
}
