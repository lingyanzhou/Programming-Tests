package lzhou.programmingtest.leetcode.test201;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int ret = m;
        for (int i=0; i<31; ++i) {
            if ((m&(1<<i))!=0) {
                long nextBit = 1L<<(i+1);
                long lowerBitsMask = nextBit-1;
                long lowerBits = m&lowerBitsMask;
                
                if (nextBit-lowerBits>n-m) {
                    break;
                } else {
                    ret&=~(1<<i);
                }
            }
        }
        return ret;
    }
}
