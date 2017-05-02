# [Leetcode] 502 IPO

[link](https://leetcode.com/problems/ipo/)

## Greedy and Heap solution

* Greedy: To maximize the final capital, we only need to maximize the profit for each step, without outspending our current capital.

* Sort the projects by capital. 

* Read the project array from low capital to high capital.
    * If the project's capital is within our capital, meaning that we may have other choices, put them in a heap, and keep reading.
    * If at one point, a project's capital exceeds our own capital, our current choices are all in the heap. So pick the head of the heap. And keep reading.

* If we reached the end of the array, but haven't used up the project quota, keep poping the heap, and if the project at the heap head is affordable, choose it.
