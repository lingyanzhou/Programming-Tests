# [Leetcode] 394. Decode String

[Leetcode link](https://leetcode.com/problems/decode-string/)

[Lintcode link](https://www.lintcode.com/en/problem/expression-expand/)

## Non-Recursive solution

Time: O(n)

* Scan the string from left to right.

* At each '[', push an empty buffer and the repeat number onto a stack.

* At each ']', pop the stack, expand the popped expression, append it to the current stack head's buffer.

* After the scan, the stack has one element, and its buffer is the expanded string.
