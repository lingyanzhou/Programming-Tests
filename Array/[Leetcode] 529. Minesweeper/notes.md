#Leetcode 529. Minesweeper 
[Link](https://leetcode.com/problems/minesweeper/)

DFS solution

* Check whether the click point is a mine. If it is a mine, mark it as 'X' and exit.
* If it is not a mine, and is not marked (ie. it is 'E'):
  * If the 8-connected region has a mine, calculate the adjacent mine count, mark it and exit.
  * Otherwise, mark is as 'B', recursively do the step for its 8-connected elements.
