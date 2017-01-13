package lzhou.programmingtest.leetcode.test89;

import java.util.*;


public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer>ret= new ArrayList<Integer>((int)Math.pow(2,n));
        ret.add(0);
        if (n==0) {
            return ret;
        }

        //The second half of the code is the reverse of the first half with the ith bit set.
        for(int i=0; i<n;++i) {
            int highBit = 1<<i;
            for(int j=(int)Math.pow(2,i)-1; j>=0; --j) {
                ret.add(ret.get(j)+highBit);
            }
        }
        return ret;
    }
}
