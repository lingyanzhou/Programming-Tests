package lzhou.programmingtest.leetcode.test372;

import java.util.*;

public class Solution {
    public int superPow(int a, int[] b) {
        int len = b.length;
        if (len==0) {
            return 0;
        }
        a = a%1337;
        if (a<=1) {
            return a;
        }

        int ret = 1;

        int nextA = 1;
        for (int last = len-1; last>=0; --last) {
            nextA = 1;
            for (int i=0; i<b[last]; ++i) {
                nextA *=a;
                nextA %=1337;
            }
            ret*=nextA;
            ret%=1337;
            for (int i=b[last]; i<10; ++i) {
                nextA *=a;
                nextA %=1337;
            }
            a=  nextA;
        }

        return ret;
    }
}
