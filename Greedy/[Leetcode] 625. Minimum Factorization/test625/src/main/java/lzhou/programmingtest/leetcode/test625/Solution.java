package lzhou.programmingtest.leetcode.test625;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public int smallestFactorization(int a) {
        if (a<=0) {
            return 0;
        }
        if (a<10) {
            return a;
        }
        List<Integer> factors = new ArrayList<Integer>();
        for (int i=9; i>1; --i) {
            while (a%i==0) {
                factors.add(i);
                a /= i;
            }
        }
        if (a!=1) {
            return 0;
        }
        long tmp = 0;
        for (int i=factors.size()-1; i>=0; --i) {
            tmp = tmp*10+factors.get(i);
            if (tmp>Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) tmp;
    }
}
