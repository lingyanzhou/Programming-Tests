#[Lintcode] 91. Minimum Adjustment Cost

## DP solution

 * dp[i][j] means the min cost when we choose value j for A[i] and all A[0..i-1] has been chosen.
 * Transfer:
   ```
   dp[i][j] = min(dp[i-1][j-target...j+target])+(j-A[i])
   ```
