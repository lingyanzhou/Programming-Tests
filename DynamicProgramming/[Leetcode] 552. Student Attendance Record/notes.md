# [Leetcode] 552. Student Attendance Record II

[Link](https://leetcode.com/problems/student-attendance-record-ii)

## Simple Recursion solution

*This solution causes stack overflow exception when `n` is large.*

* `checkRecordHelper(n, a, l)` gives the number of rewardable records for `n`-length records, `a` previous absent count, and `l` previous adjacent late count.
```java
checkRecordHelper(n, a, l) = checkRecordHelper(n-1, a+1, 0) + 
                            checkRecordHelper(n-1, a, l+1) + 
                            checkRecordHelper(n-1, a, 0)
```
* The final result is `checkRecordHelper(n, 0, 0)`


## Dp solution

* State: `dp[n][a][l]` indicates the number of rewardable records for `n`-length records, `a` total absent count, and `l` total adjacent late count.
    * Initially, `dp[0][0][0] = 1`
* Transfer:
    * `dp[n][0][0] = dp[n-1][0][0] + dp[n-1][0][1] + dp[n-1][0][2]`
    * `dp[n][0][1] = dp[n-1][0][0]`
    * `dp[n][0][2] = dp[n-1][0][1]`
    * `dp[n][1][0] = dp[n-1][0][0] + dp[n-1][0][1] + dp[n-1][0][2] + dp[n-1][1][0] + dp[n-1][1][1] + dp[n-1][1][2]`
    * `dp[n][1][1] = dp[n-1][1][0]`
    * `dp[n][1][2] = dp[n-1][1][1]`
* Result:
`sum(dp[n][0][0],dp[n][0][1],dp[n][0][2],dp[n][1][0],dp[n][1][1],dp[n][1][2])`

## Further Optimization

* Transfer function as matrix multiplication:

```
[dp'00 dp'01 dp'02     0     0     0]   [dp00 dp01 dp02    0    0    0][1 1 0 0 0 0]
[dp'10 dp'11 dp'12 dp'00 dp'01 dp'02] = [dp10 dp11 dp12 dp00 dp01 dp02][1 0 1 0 0 0]
                                                                       [1 0 0 0 0 0]
                                                                       [1 0 0 1 1 0]
                                                                       [1 0 0 1 0 1]
                                                                       [1 0 0 1 0 0]

D(n+1) = D(n)*T
```

* `D(n)= D(0)*T^n`
