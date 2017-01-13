package lzhou.programmingtest.leetcode.test29;

import java.util.*;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend==0) {
            return 0;
        }
        if (divisor==0) {
            return Integer.MAX_VALUE;
        }
        long dd = dividend;
        long ds = divisor;
        long sign = 1;

        if (dd<0) {
            dd = -dd;
            sign = -sign;
        }
        if (ds<0) {
            ds = -ds;
            sign = -sign;
        }

        int shift=0;
        long dsShifted = ds;

        //Find the highest bit that results in 1, then do long division
        while (dd>=dsShifted) {
            shift+=1;
            dsShifted = dsShifted<<1;
        }
        shift -=1;
        dsShifted = dsShifted>>>1;
        long ret = 0;
        while (dd>=ds) {
            if (dd>=dsShifted) {
                ret += 1L<<shift;
                dd -= dsShifted;
                dsShifted = dsShifted>>1;
                shift-=1;
            } else {
                dsShifted = dsShifted>>1;
                shift-=1;
            }
        }
        ret*=sign;
        ret = Math.min(ret, Integer.MAX_VALUE);
        ret = Math.max(ret, Integer.MIN_VALUE);
        return (int)ret;
    }
}
