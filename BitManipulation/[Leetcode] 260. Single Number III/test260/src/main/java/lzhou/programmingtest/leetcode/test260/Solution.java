package lzhou.programmingtest.leetcode.test260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int twoSingleXored = singleNumber1(nums);

        int firstBitDiff = ((0xFFFFFFFF-twoSingleXored+1) & twoSingleXored);

        int s1=0;
        int s2=0;
        for (int i:nums) {
            if ((firstBitDiff & i) !=0) {
                s1 ^= i;
            } else {
                s2 ^= i;
            }
        }

        return new int[]{s1, s2};
    }

    private int singleNumber1(int[] nums) {
        int xored = 0;
        for (int i: nums) {
            xored ^= i;
        }
        return xored;
    }
}
