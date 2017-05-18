# [Leetcode] 354. Russian Doll Envelopes

[Leetcode link](https://leetcode.com/problems/russian-doll-envelopes/)

[Lintcode link](https://www.lintcode.com/en/problem/russian-doll-envelopes/)

## Naive O(n^2) solution

* Sort the envelopes descendingly by its length, and its width.

* Keep an array of each envelopes nested level.

* Scan the envelopes from left (largest) to right (smallest),
    * Scan all the envelopes larger than itself. Find the most nested one, whose nested level is `n`.
    * Set the nested level of the current envelopes to `n+1`.

## Binary search

* Basic idea:
    * If their length are distinct, after sorting them by the length, the right elements always have a smaller length than their left.
    * Whether they can be nested is only determined by their width.
    * Their width can be stored in an ordered array, and the position tells their nested level.
    * If their length can have duplicates, we need to avoid puting envelopes with the same length inside each other. To do this, subsort the envelopes ascendingly by its width.

* Sort the envelopes descendingly by its length, then ascendingly by its width.

* Keep an array `widthsAt`. The index is the nested level. The value is the maximum widths of envelopse at this level.

* Scan the envelopes from left (largest length) to right.
    * At each iteration, it is certain that `widthsAt` records envelopes with larget length, or with the same length but less width.
    * Binary search for the current envelopes width in `widthsAt`. What's before the index, represents envelopes that can contain the current envelope. This automatically eliminates envelopes with the same length but less width.
    * Obviously, it should be put at the most nested level (the largest index) possible. Either a new nested level is added, or update the an existing nested level. When updating, keep the largest width.
