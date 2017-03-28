#Leetcode 490. The Maze

DFS

* If the current block is marked `TEST`, return `false`. 
* Mark the current block as `TEST`.
* Move the ball left/right/up/down, do the above steps recursively.

Optimiztion

* Preprocess the maze, for each empty block, find the blocks after moving 1 left/right/up/down step.
