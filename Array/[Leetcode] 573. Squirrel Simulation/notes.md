# [Leetcode] 573. Squirrel Simulation

[Link](https://leetcode.com/contest/leetcode-weekly-contest-31/problems/squirrel-simulation/)

* The squirrel has to choose one nut to carry first. The distance involved is the distance between the squirrel and the nut, and the distance between the but and the tree.

* Now the squirrel is at the tree. for all the rest nuts, each require twice the distance between the tree and the nut.

* So only the first choice is important. We iterate through the nuts, trying each one as the first one, and select the minimum result.
