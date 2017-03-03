# Leetcode 524. Longest Word in Dictionary through Deleting
[link](https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/?tab=Description)

Two pointer solution:

* Iterate through the dictionary. For each string `w` in the dictionary, use two pointer method to test whether `w` can be created by deleting characters from `s`.
* Two pointer: `i`, `j` are indices of characters in `s` and `w`. 
* While `i` and `j` are valid indices, if s[i]==w[j], increment `i` and `j`, otherwise increment `i` only.
* If `j` becomes invalid, then `w` can be created by deleting characters from `s`.
* The result is the longest and smallest in lexicographical `w`..
