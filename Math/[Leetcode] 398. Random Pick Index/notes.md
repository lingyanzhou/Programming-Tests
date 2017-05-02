# [Leetcode] 398. Random Pick Index

[Link](https://leetcode.com/problems/random-pick-index)

## Reservoir Sampling

* `n` is how many element of interest has been met, including the current element; `index` is the result.
* Iterate through the collection. If the element is the target, increment `n`; it has `1/n` chance of been selected.
    * If it is selected, update `index`.
* Then after reading through the array, each element of interest will have eaqual chance of being selected.
* Simple proof:
    * For the `1`-st element, `n=1`, it must be selected.
    * For the `2`-nd element, `n=2`, it has `1/2` chance to be selected, and the `1-st` has `1/2` chance to remain.
    * For the `3`-rd element, `n=3`, it has `1/3` chance to be selected, and the old value has `2/3` chance to remain. The probability of a specific old value to remain is `1/2*2/3=1/3`.
    * For the `m`-th element, `n=m`, it has `1/m` change to be selected, and the old value has `(m-1)/m` chance to remain. The old value has `m-1` equally possible values, meaning each possible old value is `1/(m-1)*(m-1)/m` likely to be selected.

