# [Leetcode] 456. 132 Pattern

[Leetcode Link](https://leetcode.com/problems/132-pattern/)
[Lintcode Link](https://www.lintcode.com/en/problem/132-pattern/)

## `O(n^3)` algorithm

* Use three indices `i`, `j`, `k` to find the pattern.

* Use tThree loops to probe all possible `i`, `j`, `k` combinations.
    * Scan `i` from left to right
    * Scan `k` from right to `i`
    * Scan `j` from `i` to `k`

## `O(n^2)` algorithm

* Split the array into two parts. The first part corresponds to pattern `1`.
The second part corresponds to pattern `32`.

* Two loops are used.
    * The we find the boundary of the two parts by scanning from left to right.
During the scan, we keep track of the minimal value in part 1.

    * For each boundary, scan the second part from left to right, use the maximum value so far as pattern '3'. Use a smaller value of pattern `2`.
If the `2` value is greater than `1` value, we found a `132` pattern.

## `O(n)` algorithm

* Conceptually, `132` pattern splits the array into two parts, the first part `1`, the second `32`.

* Prescan the array from left to right, at each index, record in an array the min values so far as `1`.

* Scan the array again, from right to left. Prepare a stack for `32` candidates.
    * At each step, keep poping the stack if its head is less than the current `1` value.
    * If the current element is greater than `1` value, push it to the stack.
    * If the stack has two or more elements, and the first two element has `32` pattern, we hav found the `132` pattern.
