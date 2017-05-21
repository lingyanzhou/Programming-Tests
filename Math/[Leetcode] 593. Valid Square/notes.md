# [Leetcode] 593. Valid Square

[Link](https://leetcode.com/problems/valid-square/)

* Sort the four points. The lower left point is `points[0]`, upper left at 1, lower right at 2, upper right at 3

* Then a square requires 
   1. four angles are 90 degrees. Eg. The upper right angle should be 90 degrees, requiring `(points[1]-points[0]) dot (points[3]-points[1]) == 0`.
   2. The eades' lengths are at not 0.
   3. The two adjacet edges are equal in length.
