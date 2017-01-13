package lzhou.programmingtest.leetcode.test50;

import java.util.*;

public class Solution 
{
    public double myPow(double x, int n) {
        if (n==0) {
            return 1;
        }
        if (n<0) {
            if (n==Integer.MIN_VALUE) {
                n/=2;
                x*=x;
            }
            return 1.0/myPow(x, -n);
        }
        if (x==1) {
            return 1;
        }
        if (n%2==0) {
            if (x==-1) {
                return 1;
            }
            double tmp = myPow(x, n/2);
            return tmp*tmp;
        } else {
            if (x==-1) {
                return -1;
            }
            double tmp = myPow(x, n/2);
            return x*tmp*tmp;
        }
    }
}
