# [Leetcode] 140. Word Break II

[Leetcode link](https://leetcode.com/problems/word-break-ii/)

[Lintcode link](https://www.lintcode.com/en/problem/word-break-ii/)

## DP solution

* State: `dp[string]` is the list of possible combination of the substring `string`.

* Transition function: `dp[word+string]=dp[string].flatMap(it=>word+" "+it)`

