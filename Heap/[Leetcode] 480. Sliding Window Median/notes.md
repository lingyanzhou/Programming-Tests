# [Leetcode] 480. Sliding Window Median

[link](https://leetcode.com/problems/sliding-window-median/)

## Two heap solution

Time: O(nk), or O(n log k) when optimized

* Use two heaps to order the `k` elements. A min heap keep the biggest `k/2` elements, a max heap keep the smalles `k-k/2` elements. 
* The median is the max heap's head when `k` is odd, or the mean of both heaps' heads when `k` is even.
* When moving the window, adding an element is O(log k), removing an old element is O(k). If a custom heap implementation with a hash map is used, both operation can be O(log k).
