package lzhou.programmingtest.leetcode.test172;

public class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public int trailingZeroes(int n) {
        int ret = 0;
        long pow5 = 5;
        while (n>pow5) {
            ret+= n/pow5;
            pow5 *=5;
        }
        return ret;
    }
}
