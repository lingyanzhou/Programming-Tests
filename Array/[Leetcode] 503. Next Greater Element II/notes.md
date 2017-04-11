# [Leetcode] 503. Next Greater Element II

[Link](https://leetcode.com/problems/next-greater-element-ii/)

## Stack solution

* Keep a stack of (`index`,`value`) pairs.
* The stack is decreasing w.r.t. each element's `value`.
* Iterate through the `nums` array, try to push the (`i`,`nums[i]`) pair onto the stack.
  * While the stack head's `value` is less than `nums[i]`, remove the stack head, and the next greater value for `index` is the new `nums[i]`.
* Iterate though the `nums` array the second time, but do not push any new pairs. Terminate the loop when the stack is empty (all next greater elements are found) or when the `index` equals the stack head's `index` (we've done a circular search).
