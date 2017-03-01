package lzhou.programmingtest.leetcode.test525;

import java.util.*;

public class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        int n = nums.length;
        HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
        for (int i=0, tmp=0; i<nums.length; ++i) {
            if (nums[i]==0) {
                tmp-=1;
            } else {
                tmp+=1;
            }
            table.put(tmp, i);
        }

        int ret = 0;
        for (int i=0, tmp=0; i<nums.length; ++i) {
            if (table.containsKey(tmp)) {
                ret = Math.max(ret, table.get(tmp)-i+1);
            }
            if (nums[i]==0) {
                tmp-=1;
            } else {
                tmp+=1;
            }
        }
        return ret;
    }
}
