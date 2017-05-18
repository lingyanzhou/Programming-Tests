# [Leetcode] 587. Erect the Fence

[Link](https://leetcode.com/problems/erect-the-fence/)

## QuickHull solution

* Given a line, one convex hull point is the furthest away from the line.

* First, find the leftmost and rightmost points. They are on the convex hull.

* Draw a line across them, split the points into two parts. Recursively do the following:
    * Find the furthest point away from the line. The point is on the convex hull.
    * Make two new lines, from the new point to the terminals of the current line.
    * Each new line split the points into two parts. One part is within the convex, and can be discarded. Recurse on the other part.

