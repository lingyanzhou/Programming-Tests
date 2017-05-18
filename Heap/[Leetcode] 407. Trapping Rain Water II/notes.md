# [Leetcode] 407. Trapping Rain Water II

[Leetcode Link](https://leetcode.com/problems/trapping-rain-water-ii/)

[Lintcode Link](https://www.lintcode.com/en/problem/trapping-rain-water-ii/)

## Heap solution

* Keep a min heap of walls. Move from outter layer to inner. Remember the highest wall so far. Then the waters inside walls in the heap, will not be higher than the heap head, and the highest wall seen so far.

* Initialy, put all borders in the heap.

* While the heap is not empty:
    * Take the heap head.
    * Add adjacent not-seen walls to the heap.
    * If the wall is higher than the current highest wall, updat the current highest wall.
    * If the wall is lower, then calculate the water trapped in this block.
