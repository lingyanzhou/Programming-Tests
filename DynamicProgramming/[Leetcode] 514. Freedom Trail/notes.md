# Leetcode 514. Freedom Trail
[link](https://leetcode.com/problems/freedom-trail/)

## DP solution
* State: `dp[i][k]` means the total steps consumed when `i`-th key character is found at the k-th ring position, and all previous characters are found.
* Transfer function:
```
if key[k1]==ring[i+1]
    dp[i+1][k1] = min(dp[i+1][k1], dp[i][k2] + 1 + rotationStep)
```
* The `rotationStep` need to be calculated twice, CCW and CW.
