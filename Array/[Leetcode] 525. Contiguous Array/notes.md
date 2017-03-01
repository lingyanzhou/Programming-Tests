#Leetcode 525. Contiguous Array
[Link](https://leetcode.com/problems/contiguous-array/)

Hash Table Solution:
O(n)

* Iterate through the array for the first time. For each `index`, calculate the the difference (`diff`) of the numbers of previous 0s and 1s; put the (`diff`, `index`) pair in the table.
* Iterate through the array for the second time. For each `index`, calculate the the difference (`diff`) of the numbers of previous 0s and 1s. If the table has key `diff`, we found one candidate with length `index-table.get(diff)+1`.
