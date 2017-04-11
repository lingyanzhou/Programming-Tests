# Leetcode 513. Find Bottom Left Tree Value

[Link](https://leetcode.com/problems/find-bottom-left-tree-value/)

## DFS solution

* If the root has no children, return its value.
* Else, use DFS to find the bottom-left-node of the left sub tree, then that of the right subtree, and return the deeper one.
