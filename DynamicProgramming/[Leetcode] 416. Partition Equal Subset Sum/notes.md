# [Leetcode] 416. Partition Equal Subset Sum

[Leetcode Link](https://leetcode.com/problems/partition-equal-subset-sum/)

[Lintcode Link](https://www.lintcode.com/en/problem/partition-equal-subset-sum/)

## Naive DP

* Keep a set of values, as the differences of the two partition.

* Transition function: The new set contains the previous set's values plus and minus a number.

* If the final set contains 0, the array can be partitioned into two equal sum subset.

## Improved

* The problem is equivalent to finding a subset which sums to `sum/2`.

* State: `dp[i]` means whether a subset can sum to `i`.

* Transition function: `dp[i] = dp[i] || dp[i-num]`

* If `dp[sum/2]==true`, the array can be partitioned into two equal sum subset.
