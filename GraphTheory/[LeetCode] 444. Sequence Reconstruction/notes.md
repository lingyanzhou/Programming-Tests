# [LeetCode] 444. Sequence Reconstruction

[Link](https://leetcode.com/problems/sequence-reconstruction/)

* Idea:
    * For the original to be uniquely reconstructed by the sequences, the first two pair of the original must be uniquely determined. This requires sequences to have the pair and the two number must be adjacent.
    * Recursively apply the above rule, all adjacent pairs in the original must be found in the sequences.
* Procedure
    * Process all sequnces, get all adjacent pairs into a set.
    * Process the origial, check that all adjacent pairs are in the set.
