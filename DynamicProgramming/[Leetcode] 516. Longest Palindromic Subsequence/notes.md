#Leetcode 516. Longest Palindromic Subsequence 
[link](https://leetcode.com/problems/longest-palindromic-subsequence/)

DP + Two pointer solution

* States for DP: two pointers' positions. `dp[i][j]` means the longesst palindromic subsequence's length in substring from index `i` to `j`. 
* Initially,the two pointers point to 0 and the end of the string.
* Transition: If `s[i]==s[j]`, `dp[i][j] =  2+dp[i+1][j-1]`, else `dp[i][j] =  max(dp[i+1][j], dp[i][j-1])`
