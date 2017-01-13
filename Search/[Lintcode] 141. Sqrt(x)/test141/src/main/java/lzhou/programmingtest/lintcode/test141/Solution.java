package lzhou.programmingtest.lintcode.test141;

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        long start = 0;
        long end = (long)x+1;
        while (start<end) {
            long mid = end+start;
            mid/=2;
            long mid2 = mid*mid;
            if (mid2==x) {
                return (int)mid;
            } else if (mid2<x) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return (int)start-1;
    }
}
