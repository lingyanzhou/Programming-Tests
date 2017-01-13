package lzhou.programmingtest.leetcode.test268;


//Bit Manipulation: xor the given numbers and 1..n. 
public class Solution2 {
    public int missingNumber(int[] nums) {
        int xored = 0;
        for (int i: nums) {
            xored^=i;
        }
        for (int i=1; i<=nums.length; ++i) {
            xored^=i;
        }
        return xored;
    }
}
