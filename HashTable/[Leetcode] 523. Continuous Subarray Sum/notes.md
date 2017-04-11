# 523. Continuous Subarray Sum

[link](https://leetcode.com/problems/continuous-subarray-sum/)

##  Hashtable solution

Space: O(min(n, k)), Time: O(n) 

* From left to right, calculate the running sum mod `k` (denoted as `sum`).
* Use a hash table to record currently seen  `sum`, and their  indices.
* If  `sum` is already in the table, and its index is at least 2 smaller than the current index, we found a solution subarray.
* Otherwise, add it to the hash table, and continue.

* Special case when k==0: returns true if two or more consecutive element are zero.
