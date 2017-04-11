# 498. Diagonal Traverse

[Link](https://leetcode.com/problems/diagonal-traverse/)

* Basic Idea
    * For odd diagnals, traverse in this order `[r,c]->[r-1,c+1]`
    * For even diagnals, traverse in this order `[r,c]->[r+1,c-1]`
* Boundary cases:
    * When left border is hit, goto `[r+1,0]`
    * When top border is hit, goto `[0,c+1]`
    * When right border is hit, goto `[r+1,c]`
    * When bottom border is hit, goto `[r,c+1]`
