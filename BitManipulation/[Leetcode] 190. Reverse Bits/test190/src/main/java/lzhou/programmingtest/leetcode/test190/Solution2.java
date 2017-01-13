package lzhou.programmingtest.leetcode.test190;

public class Solution2 {
    // you need treat n as an unsigned value
                //  0   0x1 0x2  0x3  0x4  0x5  0x6  0x7  0x8  0x9  0xA  0xB  0xC  0xD  0xE  0xF
    byte[] table = {0, 0x8, 0x4, 0xC, 0x2, 0xA, 0x6, 0xE, 0x1, 0x9, 0x5, 0xD, 0x3, 0xB, 0x7, 0xF};
    public int reverseBits(int n) {
        int ret = 0;
        for (int i=0; i<=28; i+=4) {
            ret |= table[n<<i>>>28]<<i;
        }
        return ret;
    }
}
