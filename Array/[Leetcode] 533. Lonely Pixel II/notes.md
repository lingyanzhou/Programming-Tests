# [Leetcode] 533. Lonely Pixels II

[Link](https://leetcode.com/problems/lonely-pixel-ii/)

## Hash table soliution

* Scan the table once, put each row's index and 'B' count in a map, row index -> 'B' count.
* Scan the table once, put each column's index and 'B' count in a map, col index -> 'B' count.
* Scan the table once, put each distinct row and occurance in a hash table, row content -> count.
* Scan the table once, then at row `i` and column `j`, if the above three count all equal `n`, increase the result by 1.
