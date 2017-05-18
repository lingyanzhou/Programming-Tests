# [Leetcode] 282. Expression Add Operators

[Leetcode link](https://leetcode.com/problems/expression-add-operators/)

[Lintcode link](https://www.lintcode.com/en/problem/add-operators/)

## Backtracking

* Simplify all expressions into this form `curval = prevval+lastMultiplication`, `lastMultiplication = coeff * lastNum`.

* `lastNum` is always treated as part of `lastMultiplication`. Eg. `a+b` => `a+1*b`

* `-` operator is treated as `+` and a unary `-`. `a-b` => `a+(-1*b)`. So we have three operator to deal with, +, *, concatenation.

* Do not do lookahead, because by remembering `lastNum` `lastMultiplication`, we can correct the result based on them.

 Eg.
  |-----------------|------------------|--------------------------|--------------------------|
  | Some step: +    |                   |  `curval=prevval+c*b`  |  `lastMultiplication=c*b` | 
  | Next step:    |                     |                         |                        |
  |  Concatenation |      `b' = b*10+c` | `curval' = curval-b+b'` | `lastMultiplication'=lastMultiplication/b*b'=c*b'` |
  |  + |      `b' = c` | `curval' = curval+b'` | `lastMultiplication'=b'` |
  |  - |      `b' = c` | `curval' = curval+(-1)*b'` | `lastMultiplication'=-1*b''` |
  |  * |      `b' = c` | `curval' = curval-lastMultiplication +lastMultiplication'` | `lastMultiplication'=lastMultiplication*b'=c*b*b'` |
  |-----------------|------------------|--------------------------|--------------------------|

## Divide and conquer solution

* Recursively divide the string by `+`, `-`, `*` into two parts, or simply parse it as integer value.

* To deal with preprecedence, we restrict what can be nested. 
    * If a string is divided by `+`, it can be further divided by `+` (for the fisrt part only), `-`, `*`
    * If a string is divided by `-`, it can be further divided by `-` (for the fisrt part only), `*`. 
    * If a string is divided by `*`, it can be further divided by `*`

* To eliminate duplication, we futher forbid the use of the same divisor in the second part. So the divisor position we use at this level will be the rightmost divisor position for nested levels.

* Another reason to fix the rightmost divisor first is to deal with the left-associtivity of `-`.
