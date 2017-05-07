# [Leetcode] 576. Out of Boundary Paths

[Link](https://leetcode.com/contest/leetcode-weekly-contest-31/problems/out-of-boundary-paths/)

## DP solution

* State: `dp[N][m][n]` means the number of out-of-boundary paths that start from the block at `[m][n]` and that are exactly `N` steps long.

* Transfer: `dp[N+1][m][n]=dp[N][m-1][n]+dp[N][m+1][n]+dp[N][m][n-1]+dp[N][m][n+1]`

* Initialization: `dp[1][m][n]=number of neighboring borders`.

* Then the result is `sum(do[1..N][i][j])`

* Optimization: only keep `dp` and `dpNext`.
