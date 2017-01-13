package lzhou.programmingtest.leetcode.test190;

public class Solution1 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i=0; i<16; ++i) {
            ret |= (n&(1<<i))<<(31-2*i);
        }
        for (int i=16; i<32; ++i) {
            ret |= (n&(1<<i))>>>(2*i-31);
        }
        return ret;
    }
}
