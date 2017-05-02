package lzhou.programmingtest.leetcode.test548;

import java.util.*;
import java.util.stream.*;

public class Solution 
{
    public boolean splitArray(int[] nums) {
        long[] sum = new long[nums.length+1];
        IntStream.range(0, nums.length).forEach(i->sum[i+1]=sum[i]+nums[i]);
        return IntStream.range(0, nums.length-1).anyMatch(i->{
            return IntStream.range(i+1, nums.length).anyMatch(j->{
                return sum[i]==sum[j]-sum[i+1] && sum[i]==sum[nums.length]-sum[j+1];
            });
        });
    }
}
