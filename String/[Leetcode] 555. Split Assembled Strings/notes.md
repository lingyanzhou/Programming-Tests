# [Leetcode] 555. Split Assembled Strings

[Link](https://leetcode.com/problems/split-assembled-strings/)

* First, compare each string with the reversed version, change it to whichever is lexicographically bigger.
* Find the max character in the strings.
* For each string,if it does not have the max character, skip it. If it has the max character, do the following:
    * For each max character in the string, consider it a candidate break point.
    * Build the resultant string. Simple split the string of interest into 2 parts, concatenate the first part, with the rest strings starting from the current index in circular order, and the second part.
    * Test if it is the lexicographically largest.
 
