package lzhou.programmingtest.leetcode.test526;

import java.util.*;

public class Solution {
    public int countArrangement(int N) {
        boolean[] used = new boolean[N];
        return countArrangementHelper(used, 1);
    }
    
    private int countArrangementHelper(boolean[] used, int index) {
        if (index==used.length+1) {
            return 1;
        }
        int ret = 0;
        for (int i=0; i<used.length; ++i) {
            if(!used[i] && ((i+1)%index==0 || index%(i+1)==0)) {
                used[i]=true;
                ret += countArrangementHelper(used, index+1);
                used[i]=false;
            }
        }
        return ret;
    }
}
