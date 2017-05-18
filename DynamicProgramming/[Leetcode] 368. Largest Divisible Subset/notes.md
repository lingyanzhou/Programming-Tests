# [Leetcode] 368. Largest Divisible Subset

[Leetcode link](https://leetcode.com/problems/largest-divisible-subset/)

[Lintcode link](https://www.lintcode.com/en/problem/largest-divisible-subset/)

## DP solution

Time: `O(n^2)`

* Whether a new element is divisible by every element in a divisible set, is determined by the largest element in the set.

* Sort the array. Then use DP:

    * State: `dp[i]` means the set with its largest element `nums[i]`.

    * Transfer function: `dp[i+1] = 1 + max([dp[j] for j in [0..i] and nums[i+1]%nums[j]==0])`

* Keep the selected divisible's index in a `prevs` array. `prevs[i+1]=maxarg_{j in [0..i]}(dp[j])`.

* To reconstruct the longest set, scan `dp` array, find the maximum value, and from that index follow `prevs` array.
