# [Leetcode] 568. Maximum Vacation Days

[Link](https://leetcode.com/problems/maximum-vacation-days/)

## DP solution

* State: `dp[location][week]` means the maximum vacation days if the traveler is at `location` in week `week`.
* Transition:

```
for each location 'newLocation'
    if 'newLocation' is reachable
        dp[location][week] = max(dp[location][week], days[location][week]+dp[newLocation][week+1])
```


