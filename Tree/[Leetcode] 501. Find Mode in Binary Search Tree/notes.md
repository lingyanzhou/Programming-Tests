# 501. Find Mode in Binary Search Tree

## Inorder traversal

* Basic idea

  * Simple traverse the tree in in-order traversal order.
  * Remember the last value and its occurance.
  * Keep an array of possible modes. Keep the modes' occurance.
  * If the current value occurance equals the modes', add it to the modes.
  * If the current  value occurance is greater than the modes', clear the modes, add the curret value to it, and update the modes' length.
 
* Optimization

  * 2-pass traversal. The first time, find the modes' occurance. The second time, find all vaalues that occurs that many times.
