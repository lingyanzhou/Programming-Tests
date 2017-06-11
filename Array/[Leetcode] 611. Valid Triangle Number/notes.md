# [Leetcode] 611. Valid Triangle Number

[Link](https://leetcode.com/problems/valid-triangle-number/)

## Two Pointer solution

* Sort the number ascendingly.
* Define two pointers, initially `i` points to the leftmost number, `j` points to the rightmost number. In the outter iteration, `i` moves to the right. In the inner iteration, `j` moves to the left.
* Then the problem is to find `k` such that `nums[i]`, `nums[k]`, `nums[j]` form a valid triangle.
* Because the `nums` array is sorted, obviously `nums[k]<= nums[j] < nums[i] + nums[j]`.
* Binary search for k so that `nums[j] - nums[i] < nums[k]`. Then all numbers between index `k` and `j` can form a triangle.
* To optimize, skip the inner iteration if `nums[i]` is 0.
