##Binary search tree solution:

1. Each interval sum can be found as `sum[i..j]=sum[0..j]-sum[0..i]`
2. put previous sum in a binary search tree
3. Then to find `lower<=sum[i..j]<=uppwer`, is equivalent to find `sum[0..j]-upper<=sum[0..i]<=sum[0..j]-lower`

##Segment Tree solution

1. Calculate the integral array. Sort the integral array.
2. Create a segment tree, with leaves corresponding to entries in the integral array. Their count is set to 0.
3. Calculate the integral array again. At each step, find in the segmentation tree how many previous sums are between `sum-upper` and `sum-lower` . Then add `sum` to the tree.
